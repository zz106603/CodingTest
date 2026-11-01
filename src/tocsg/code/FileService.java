package tocsg.code;

import tocsg.code.exception.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class FileService {

    /*
    요구사항

    사용자가 파일을 업로드하면 서버의 임시 작업 영역에 원본 파일이 저장된다.
    업로드된 파일은 주기적으로 변환 작업의 대상이 된다.
    현재 변환 작업 중인 파일은 다른 작업에 의해 처리되거나 삭제되어서는 안 된다.
    변환이 완료된 파일의 원본은 추후에 NAS에 백업해야 한다.
    NAS 백업이 정상적으로 완료된 경우에만 서버의 원본 파일을 삭제해야 한다.
    NAS 백업 또는 원본 파일 삭제에 실패한 경우 해당 파일은 이후 배치에서 다시 처리할 수 있어야 한다.
    하루에 수만 개의 파일이 업로드될 수 있으며, 한 번의 배치에서 대량의 파일을 처리할 수 있다.
    파일 변환 배치는 일정한 주기로 실행된다.
    NAS 백업 및 원본 삭제 배치는 서버 부하를 고려하여 하루에 한 번 새벽 3시에 실행된다.
    파일 변환 및 원본 백업 작업에 대한 성공/실패 로그 기록을 남겨야 한다.
    배치가 실행되는 동안에도 사용자는 파일을 업로드하거나 새로운 변환 작업을 시작할 수 있다.

    파일 상태
    READY : 업로드 완료, 변환 대기 중
    PROCESSING : 변환 작업 진행 중
    COMPLETED : 변환 완료, NAS 백업 대기
    BACKUP_PROCESSING : NAS 백업 진행 중
     */

    // 파일 변환 배치
    public void processTempFiles() {

        int offset = 0;
        int size = 1000;

        while (true) {
            List<TempFile> files = db.find(
                    """     
                    SELECT *
                    FROM work_file
                    WHERE status = 'READY'
                    ORDER BY id
                    LIMIT ?, ?
                    """,
                    offset,
                    size
            );

            for (TempFile file : files) {
                Transaction tx = db.beginTransaction();
                try {
                   tx.execute(
                            """
                            UPDATE work_file
                            SET status = 'PROCESSING'
                            WHERE id = ?
                            """,
                            file.getId()
                    );

                    converter.execute(Paths.get(file.getPath()));

                    tx.execute(
                            """
                            UPDATE work_file
                            SET status = ‘DONE'
                            WHERE id = ?
                            """,
                            LocalDateTime.now(),
                            file.getId()
                    );

                    tx.execute(
                            """ 
                            INSERT INTO file_job_log (file_id, job_type, status, created_at) 
                            VALUES (?, 'CONVERT', 'SUCCESS', ?) 
                            """,
                            file.getId(),
                            LocalDateTime.now()
                    );

                    tx.commit();

                } catch (ConversionException | ConversionAlreadyExistsException e) {
                    tx.execute(
                            """ 
                            INSERT INTO file_job_log (file_id, job_type, status, created_at, message) 
                            VALUES (?, 'CONVERT', 'FAILED', ?, ?) 
                            """,
                            file.getId(),
                            LocalDateTime.now(),
                            e.getMessage()
                    );

                    tx.rollback();
                }
            }
            offset += size;
        }
    }

    // NAS 백업 및 원본 삭제 배치
    public void backupAndCleanup() {

        int offset = 0;
        int size = 1000;

        while (true) {
            List<TempFile> files = db.find(
                    """
                    SELECT *
                    FROM temp_file
                    WHERE status = 'COMPLETED'
                    ORDER BY id
                    LIMIT ?, ?
                    """,
                    offset,
                    size
            );

            if (files.isEmpty()) { break; }

            for (TempFile file : files) {
                Transaction tx = db.beginTransaction();
                try {
                    tx.execute(
                            """
                            UPDATE work_file
                            SET status = 'BACKUP_PROCESSING'
                            WHERE id = ?
                            """,
                            file.getId()

                    );

                    nasClient.upload(Paths.get(file.getPath()));
                    fileStorage.delete(Paths.get(file.getPath()));

                    tx.execute(
                            """
                            DELETE FROM temp_file
                            WHERE id = ?
                            """,
                            file.getId()
                    );



                    tx.execute(
                            """ 
                            INSERT file_job_log (file_id, job_type, status, created_at)
                            VALUES (?, 'BACKUP', 'SUCCESS') 
                            """,
                            file.getId(),
                            LocalDateTime.now()
                    );

                } catch (NasException | BackupAlreadyExistException | FileDeleteException e) {
                    tx.rollback();
                    db.execute(
                            """ 
                            INSERT INTO file_job_log (file_id, job_type, status, created_at, message) 
                            VALUES (?, 'BACKUP', 'FAILED', ?, ?) 
                            """,
                            file.getId(),
                            LocalDateTime.now(),
                            e.getMessage()
                    );

                }

            }

            offset += size;

        }

    }


}

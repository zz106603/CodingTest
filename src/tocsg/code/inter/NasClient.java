package tocsg.code.inter;

import tocsg.code.exception.BackupAlreadyExistException;
import tocsg.code.exception.NasException;

import java.nio.file.Path;

public interface NasClient {

    /**

     * 지정된 파일을 NAS에 업로드한다.

     *

     * @param source 업로드할 파일 경로

     * @throws NasException NAS 연결 또는 업로드에 실패한 경우

     * @throws BackupAlreadyExistException 이미 NAS에 백업된 파일이 존재하는 경우

     */

    void upload(Path source) throws NasException, BackupAlreadyExistException;

}

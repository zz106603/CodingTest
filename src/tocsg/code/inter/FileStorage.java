package tocsg.code.inter;

import tocsg.code.exception.FileDeleteException;

import java.nio.file.Path;

public interface FileStorage {

    /**

     * 서버의 파일을 삭제한다.

     *

     * @param path 삭제할 파일 경로

     * @throws FileDeleteException 파일 삭제에 실패한 경우

     */

    void delete(Path path) throws FileDeleteException;



    /**

     * 서버의 파일을 삭제한다.

     * 파일이 이미 존재하지 않는 경우에도 성공으로 처리한다.

     *

     * @param path 삭제할 파일 경로

     * @throws FileDeleteException 파일 삭제에 실패한 경우

     */

    void deleteIfExists(Path path) throws FileDeleteException;

}

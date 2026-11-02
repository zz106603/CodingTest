package tocsg.code.inter;

import tocsg.code.exception.ConversionAlreadyExistsException;
import tocsg.code.exception.ConversionException;

import java.nio.file.Path;

public interface Converter {

    /**

     * 지정된 원본 파일을 변환한다.

     *

     * @param source 변환할 원본 파일 경로

     * @return 변환 결과 파일의 경로

     * @throws ConversionException 파일이 없거나 변환 과정에서 오류가 발생한 경우

     * @throws ConversionAlreadyExistsException 이미 변환된 파일이 존재하는 경우

     */

    Path execute(Path source)
            throws ConversionException, ConversionAlreadyExistsException;
}

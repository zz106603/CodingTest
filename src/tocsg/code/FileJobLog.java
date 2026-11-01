package tocsg.code;

import java.time.LocalDateTime;

public class FileJobLog {

    Long id;     // id 값은 순차적으로 증가한다

    Long fileId;

    String jobType; // CONVERT, BACKUP

    String status; // SUCCESS, FAILED

    LocalDateTime createdAt;

    String message;

}

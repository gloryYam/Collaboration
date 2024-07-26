package side.dev.common.exception;

import org.springframework.http.HttpStatus;
import side.dev.common.enumType.ErrorCode;

public class DuplicateEmailException extends CustomException{

    private static final String ERROR_MESSAGE = "이미 사용하고있는 이메일입니다.";

    public DuplicateEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}

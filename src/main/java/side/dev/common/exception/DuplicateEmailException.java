package side.dev.common.exception;

import side.dev.common.enumType.ErrorCode;

public class DuplicateEmailException extends CustomException{

    private static final String ERROR_MESSAGE = "이미 사용하고 있는 이메일입니다.";

    public DuplicateEmailException() {
        super(ErrorCode.DUPLICATED_EMAIL, ERROR_MESSAGE);
    }
}

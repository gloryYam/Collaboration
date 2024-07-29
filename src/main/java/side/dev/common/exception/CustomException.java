package side.dev.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import side.dev.common.enumType.ErrorCode;

@Getter
public abstract class CustomException extends RuntimeException{

    private final ErrorCode errorCode;
    private final String errorDetailMessage;

    public CustomException(ErrorCode errorCode, String errorDetailMessage) {
        super(errorDetailMessage);
        this.errorCode = errorCode;
        this.errorDetailMessage = errorDetailMessage;
    }
}

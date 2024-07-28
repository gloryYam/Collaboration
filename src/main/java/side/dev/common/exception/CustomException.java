package side.dev.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import side.dev.common.enumType.ErrorCode;

@Getter
@AllArgsConstructor
public abstract class CustomException extends RuntimeException{

    private final ErrorCode errorCode;
    private final String errorDetailMessage;
}

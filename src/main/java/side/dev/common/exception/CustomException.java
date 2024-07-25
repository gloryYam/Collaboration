package side.dev.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import side.dev.common.enumType.ErrorCode;
import side.dev.common.response.Validation;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class CustomException extends RuntimeException{

    private ErrorCode errorCode;
}

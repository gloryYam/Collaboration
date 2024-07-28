package side.dev.common.enumType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATED_EMAIL(HttpStatus.CONFLICT,"중복된 이메일입니다.");

    private final HttpStatus httpStatus;	// HttpStatus
    private final String message;

    
}

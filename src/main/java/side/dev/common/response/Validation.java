package side.dev.common.response;

import lombok.Builder;

public class Validation {

    private String filedName;
    private String errorMessage;

    @Builder
    public Validation(String filedName, String errorMessage) {
        this.filedName = filedName;
        this.errorMessage = errorMessage;
    }
}

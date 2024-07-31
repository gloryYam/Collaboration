package side.dev.api.controller.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import side.dev.service.member.request.SignupServiceRequest;
import side.dev.domain.member.Role;

@Getter
public class SignRequest {

    @NotBlank(message = "이름을 필수입니다.")
    @Size(min = 1, max = 10, message = "이름은 1~10글자여야 합니다.")
    private final String name;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$",
            message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8~20글자여야 합니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "비밀번호는 적어도 하나의 알파벳, 숫자, 특수문자를 포함해야 합니다.")
    private final String password;

    private final Role role;

    @Builder
    public SignRequest(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public SignupServiceRequest toSignupServiceRequest() {
        return SignupServiceRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }
}

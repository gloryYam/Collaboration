package side.dev.api.service.member.request;

import lombok.Getter;
import side.dev.domain.member.Role;

@Getter
public class SignupServiceRequest {

    private final String name;
    private final String email;
    private final String password;
    private final Role role;

    public SignupServiceRequest(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

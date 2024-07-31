package side.dev.api.controller.response;

import lombok.Getter;
import side.dev.domain.member.Role;

@Getter
public class SignResponse {

    private final String name;
    private final String email;
    private final String password;
    private final Role role;

    public SignResponse(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

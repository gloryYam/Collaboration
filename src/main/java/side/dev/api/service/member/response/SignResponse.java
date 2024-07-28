package side.dev.api.service.member.response;

import lombok.Builder;
import lombok.Getter;
import side.dev.domain.member.Member;
import side.dev.domain.member.Role;


@Getter
public class SignResponse {

    private final String name;
    private final String email;
    private final Role role;


    @Builder
    public SignResponse(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public static SignResponse of(Member member) {
        return SignResponse.builder()
                .name(member.getName())
                .email(member.getEmail())
                .role(member.getRole())
                .build();
    }
}

package side.dev.domain.member;

import lombok.Getter;

@Getter
public enum Role {

     ADMIN("관리자")
    ,MANAGER("매니저")
    ,USER("일반")
    ;

    Role(String value) {
        this.value = value;
    }

    private final String value;
}

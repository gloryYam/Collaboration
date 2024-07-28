package side.dev.api.service.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import side.dev.IntegrationTestSupport;
import side.dev.api.service.member.request.SignupServiceRequest;
import side.dev.api.service.member.response.SignResponse;
import side.dev.common.exception.DuplicateEmailException;
import side.dev.domain.member.Member;
import side.dev.domain.member.Role;
import side.dev.repository.user.MemberRepository;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest extends IntegrationTestSupport {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void tearDown() {
        memberRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("회원가입 성공")
    void signMember() {
        SignupServiceRequest member1 = requestMember("glory1", "test@test1.com", "1234", Role.ADMIN);

        SignResponse signupMember = memberService.signup(member1);

        assertThat(signupMember).isNotNull();
        assertThat(signupMember)
                .extracting("name", "email", "role")
                .containsExactly("glory1", "test@test1.com", Role.ADMIN);
    }

    @Test
    @DisplayName("회원가입 시 이메일 중복시 DuplicateEmailException 발생")
    void emailDuplicated() {
        Member member = Member.builder()
                .name("glory1")
                .email("test@test1.com")
                .password("!234")
                .role(Role.ADMIN)
                .build();
        memberRepository.save(member);

        SignupServiceRequest requestMember2 = requestMember("glory2", "test@test1.com", "1234", Role.USER);

        assertThatThrownBy(() -> memberService.signup(requestMember2))
                .isInstanceOf(DuplicateEmailException.class)
                .hasMessage("이미 사용하고 있는 이메일입니다.");
    }

    private static SignupServiceRequest requestMember(String name, String email, String password, Role role) {
        return SignupServiceRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }
}
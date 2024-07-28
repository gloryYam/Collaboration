package side.dev.api.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import side.dev.api.service.member.request.SignupServiceRequest;
import side.dev.api.service.member.response.SignResponse;
import side.dev.common.exception.DuplicateEmailException;
import side.dev.domain.member.Member;
import side.dev.repository.user.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public SignResponse signup(SignupServiceRequest request) {
        emailDuplicateCheck(request.getEmail());

        /**
         * 비밀번호 인코딩 필요
         */
        Member signMember = Member.of(request.getName(), request.getEmail(), request.getPassword(), request.getRole());
        Member saveMember = memberRepository.save(signMember);

        return SignResponse.of(saveMember);
    }

    // 이메일 중복 체크
    private void emailDuplicateCheck(String email) {
        memberRepository.findByEmail(email)
            .ifPresent(memberEmail -> {
                throw new DuplicateEmailException();
            });
    }
}

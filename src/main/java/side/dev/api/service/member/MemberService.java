package side.dev.api.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import side.dev.api.service.member.request.SignupServiceRequest;
import side.dev.repository.user.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signup(SignupServiceRequest request) {
        emailDuplicateCheck(request.getEmail());
    }

    private void emailDuplicateCheck(String email) {
        memberRepository.findByEmail(email)
            .ifPresent(memberEmail -> {
                throw new EmailDuplicateException();
            });
    }
}

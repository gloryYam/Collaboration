package side.dev.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import side.dev.api.ApiResponse;
import side.dev.api.controller.request.SignRequest;
import side.dev.service.member.MemberService;
import side.dev.service.member.response.SignResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("api/auth/new")
    public ApiResponse<SignResponse> singup(@Valid @RequestBody SignRequest request) {
        return ApiResponse.ok(memberService.signup(request.toSignupServiceRequest()));
    }
}

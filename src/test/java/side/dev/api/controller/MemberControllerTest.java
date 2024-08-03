package side.dev.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import side.dev.api.controller.request.SignRequest;
import side.dev.domain.member.Role;
import side.dev.service.member.MemberService;
import side.dev.service.member.request.SignupServiceRequest;
import side.dev.service.member.response.SignResponse;

import static org.awaitility.Awaitility.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;


    @Test
    @DisplayName("회원가입 시 이메일 중복시 DuplicateEmailException 발생")
    void singup() throws Exception {
        SignRequest controllerRequest = SignRequest.builder()
                .name("glory")
                .email("test@test.com")
                .password("1234")
                .role(Role.ADMIN)
                .build();

        SignupServiceRequest serviceRequest = SignupServiceRequest.builder()
                .name("glory")
                .email("test@test.com")
                .password("1234")
                .role(Role.ADMIN)
                .build();

        BDDMockito.given(memberService.signup(serviceRequest)).willReturn(new SignResponse("glory", "test@test.com", Role.ADMIN));

        mockMvc.perform(post("/api/auth/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(controllerRequest))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("glory"))
                .andExpect(jsonPath("$.email").value("test@test.com"))
                .andDo(print());
    }
}

















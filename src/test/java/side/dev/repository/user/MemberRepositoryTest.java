package side.dev.repository.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import side.dev.domain.member.Role;
import side.dev.domain.member.Member;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("test")
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void tearDown() {
        memberRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("UserRepository CRUD 테스트 - CREATE")
    void create() {
        // given
        Member member1 = createUser("Glory", "glory@test.com", "1234", Role.USER);

        // when
        Member saveMember = em.persistAndFlush(member1);

        // then
        assertThat(saveMember).isNotNull();
        assertThat(saveMember.getName()).isEqualTo("Glory");
    }

    @Test
    @DisplayName("UserRepository CRUD 테스트 - READ")
    void read() {
        // given
        Member member1 = createUser("Glory", "glory@test.com", "1234", Role.USER);
        em.persist(member1);
        // when
        Member readMember = em.find(Member.class, member1.getId());
        // then
        assertThat(readMember).isEqualTo(member1);
    }

    @Test
    @DisplayName("UserRepository CRUD 테스트 - D")
    void delete() {
        // given
        Member member1 = createUser("Glory", "glory@test.com", "1234", Role.USER);

        em.persist(member1);
        em.remove(member1);
        em.flush();
        // when
        Member findMember = em.find(Member.class, member1.getId());

        // then
        assertThat(findMember).isNull();


    }


    public Member createUser(String name, String email, String password, Role role) {
        return Member.builder()
            .name(name)
            .email(email)
            .password(password)
            .role(role)
            .build();
    }
}
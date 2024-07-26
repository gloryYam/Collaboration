package side.dev.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import side.dev.domain.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

     Optional<Member> findByEmail(String eamil);
}

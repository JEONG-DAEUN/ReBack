package ReBack.core.Repository;

import ReBack.core.data.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
        Optional<Member> findByMemberId(String memberId);
}

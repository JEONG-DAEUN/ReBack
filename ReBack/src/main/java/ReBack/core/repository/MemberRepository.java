package ReBack.core.repository;

import ReBack.core.data.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    boolean existsByMemberId(String memberId);
    boolean existsByEmail(String email);

}


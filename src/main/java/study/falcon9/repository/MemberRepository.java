package study.falcon9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.falcon9.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

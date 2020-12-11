package study.falcon9.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void testEntity() {
        Member member = new Member();
        member.setUsername("member1");
        em.persist(member);

        Team team = new Team();
        team.setName("teamA");
        team.getMembers().add(member);
        em.persist(team);
    }
}
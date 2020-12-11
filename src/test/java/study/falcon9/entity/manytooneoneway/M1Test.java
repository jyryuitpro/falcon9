package study.falcon9.entity.manytooneoneway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
@Rollback(false)
class M1Test {

    @PersistenceContext
    EntityManager em;

    @Test
    void testEntity() {
        T1 team = new T1();
        team.setName("TeamA");
        em.persist(team);

        M1 member = new M1();
        member.setUsername("member1");
        member.setTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        M1 findMember = em.find(M1.class, member.getId());
        T1 findTeam = findMember.getTeam();

        System.out.println("findTeam.getName() = " + findTeam.getName());
    }
}
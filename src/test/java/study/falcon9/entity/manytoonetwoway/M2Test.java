package study.falcon9.entity.manytoonetwoway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.falcon9.entity.manytooneoneway.M1;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
class M2Test {

    @PersistenceContext
    EntityManager em;

    @Test
    void testEntity() {
        T2 team = new T2();
        team.setName("TeamA");
        em.persist(team);

        M2 member = new M2();
        member.setUsername("member1");
        member.setTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        M2 findMember = em.find(M2.class, member.getId());
        List<M2> members = findMember.getTeam().getMembers();

        for (M2 m : members) {
            System.out.println("m.getUsername() = " + m.getUsername());
        }
    }
}
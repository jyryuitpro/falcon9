package study.falcon9.entity.oneway;

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
        T1 t1 = new T1();
        t1.setName("TeamA");
        em.persist(t1);

        M1 m1 = new M1();
        m1.setUsername("member1");
        m1.setT1(t1);
        em.persist(m1);

        em.flush();
        em.clear();

        M1 findM1 = em.find(M1.class, m1.getId());
        T1 findT1 = findM1.getT1();

        System.out.println("findT1.getName() = " + findT1.getName());
    }
}
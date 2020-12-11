package study.falcon9.entity.manytoonetwoway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
        member.changeTeam(team); //**
        em.persist(member);

        //순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자 > 연관관계 편의 메소드를 생성하자
        team.getMembers().add(member); //**

//        team.addMember(member);

//        em.flush();
//        em.clear();

        T2 findTeam = em.find(T2.class, team.getId());
        List<M2> members = findTeam.getMembers();
        for (M2 m : members) {
            System.out.println("m.getUsername() = " + m.getUsername());
        }
    }
}
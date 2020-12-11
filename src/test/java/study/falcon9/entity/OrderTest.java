package study.falcon9.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class OrderTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void testEntity() {
        Order order = new Order();
        order.addOrderItem(new OrderItem());
    }
}
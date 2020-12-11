package study.falcon9.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    private LocalDateTime orderDate;

    //EnumType.STRING: enum 이름을 데이터베이스에 저장
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

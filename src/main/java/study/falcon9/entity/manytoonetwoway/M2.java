package study.falcon9.entity.manytoonetwoway;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class M2 {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //연관관계의 주인은 외래 키의 위치를 기준으로 정해야함
    //진짜 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private T2 team;

    //연관관계 편의 메소드
    public void changeTeam(T2 team) {
        this.team = team;
        team.getMembers().add(this);
    }

//    @Override
//    public String toString() {
//        return "M2{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
}

package study.falcon9.entity.manytoonetwoway;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class T2 {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //가짜 매핑
    @OneToMany(mappedBy = "team")
    private List<M2> members = new ArrayList<>();

    //연관관계 편의 메소드
//    public void addMember(M2 member) {
//        member.setTeam(this);
//        members.add(member);
//    }

//    @Override
//    public String toString() {
//        return "T2{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", members=" + members +
//                '}';
//    }
}

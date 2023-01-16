package com.example.demo.team_member_class.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Team")
@Entity
public class Team  {

    /**
     * /@Entity안에 직렬화 포함되어 있어서 implements Serializable는 안 해도 된다..?
     * */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;





    /**
     * 1.
     * 일대다 = 팀대멤버, 양방향 처리
     * */

    //@OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Member> members = new ArrayList<>();




    /**
     * 2.
     * 다대다, 조인테이블 생성
     * 테이블 생성까지 확인
     * insert는 좀 더 생각해보기
     * */
    /*
    @ManyToMany
    @JoinTable(
            name = "team_member",
            joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id")})
    private  List<Member> memberListJoinTable;
*/
}

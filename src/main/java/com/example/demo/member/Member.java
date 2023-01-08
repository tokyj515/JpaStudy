package com.example.demo.member;


import com.example.demo.team.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "Member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    /**
     * 3. 직접 테이블 생성하고 변수와 연결
     * 대신 결과에 teamId가 계속 나옴
     * 응답 dto로 매핑해서 반환해주는 방식으로 처리하기
     * */
    @Column(name = "team_id")
    private Long teamId;



    /**
     * 1.
     * 다대일 = 멤버대팀, 양방향 처리
     * */
    /*
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;
    */
}

package com.example.demo.member;


import com.example.demo.team.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
//@Table(name = "Member")
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "member_id")
    private Long id;

    private String name;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) //멤버n:팀1
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;


}

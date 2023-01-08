package com.example.demo.team;


import com.example.demo.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
    //@Column(name = "team_id")
    private Long id;

    private String name;

    //@OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Member> members = new ArrayList<>();

}

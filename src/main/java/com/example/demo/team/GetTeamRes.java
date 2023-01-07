package com.example.demo.team;

import com.example.demo.member.Member;
import lombok.*;

import java.util.List;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GetTeamRes {

    private Long teamId;

    private String name;

    private List<Member> members;
}

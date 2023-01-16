package com.example.demo.team_member_class.dto.team;

import com.example.demo.team_member_class.entity.Member;
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

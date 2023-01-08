package com.example.demo;


import com.example.demo.member.GetMemberRes;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.team.GetTeamRes;
import com.example.demo.team.Team;
import com.example.demo.team.TeamRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class Controller {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;



    @GetMapping("/test")
    public String test(){
        return "test";
    }


    /**
     * 일대다 , 다대일 일 때의 api
     * */
    /*
    @GetMapping("/team/{teamId}")
    public GetTeamRes getTeam(@PathVariable Long teamId){
        List<Member> memberList = memberRepository.findAllByTeam_Id(teamId);
        Team team = teamRepository.findById(teamId).get();
        return new GetTeamRes(teamId, team.getName(), memberList);
    }


    @GetMapping("/member/{memberId}")
    public GetMemberRes getMember(@PathVariable Long memberId){
        Member member = memberRepository.findById(memberId).get();
        return new GetMemberRes(member.getName(), member.getTeam().getName());
    }
     */


    @GetMapping("/team/{teamId}")
    public GetTeamRes getTeam(@PathVariable Long teamId){
        List<Member> memberList = memberRepository.findAllByTeamId(teamId);
        Team team = teamRepository.findById(teamId).get();
        return new GetTeamRes(teamId, team.getName(), memberList);
    }


    @GetMapping("/member/{memberId}")
    public GetMemberRes getMember(@PathVariable Long memberId){
        Member member = memberRepository.findById(memberId).get();
        Team team = teamRepository.findById(member.getTeamId()).get();
        return new GetMemberRes(member.getName(), team.getName());
    }


}

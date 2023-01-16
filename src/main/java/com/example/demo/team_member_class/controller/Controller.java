package com.example.demo.team_member_class.controller;


import com.example.demo.team_member_class.dto.member.GetMemberRes;
import com.example.demo.team_member_class.entity.Member;
import com.example.demo.team_member_class.repository.MemberRepository;
import com.example.demo.team_member_class.dto.team.GetTeamRes;
import com.example.demo.team_member_class.entity.Team;
import com.example.demo.team_member_class.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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



    /**
     * 직접 테이블 생성 후 연결하는 방식
     * 테이블에 외래키 변수가 있어서 엔티티 자체로 반환하면
     * 외래키 변수가 반복적으로 출력
     * 그래서 dto로 필요한 정보만 저장해서 반환하는 건가보다
     * */
//    @GetMapping("/team/{teamId}")
//    public GetTeamRes getTeam(@PathVariable Long teamId){
//        List<Member> memberList = memberRepository.findAllByTeamId(teamId);
//        Team team = teamRepository.findById(teamId).get();
//        return new GetTeamRes(teamId, team.getName(), memberList);
//    }
//
//
//    @GetMapping("/member/{memberId}")
//    public GetMemberRes getMember(@PathVariable Long memberId){
//        Member member = memberRepository.findById(memberId).get();
//        Team team = teamRepository.findById(member.getTeamId()).get();
//        return new GetMemberRes(member.getName(), team.getName());
//    }


}

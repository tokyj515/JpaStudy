package com.example.demo.team_member_class.repository;


import com.example.demo.team_member_class.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);



    //1, 2. 일대다, 다대일 일 때 사용하는 쿼리
    List<Member> findAllByTeam_Id(Long teamId);

    //3.
    //List<Member> findAllByTeamId(Long teamId);

}

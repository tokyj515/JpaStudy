package com.example.demo.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    //1, 2. 일대다, 다대일 일 때 사용하는 쿼리
    //List<Member> findAllByTeam_Id(Long teamId);


    //3.
    List<Member> findAllByTeamId(Long teamId);


    Optional<Member> findById(Long id);
}

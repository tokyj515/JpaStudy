package com.example.demo.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByTeam_Id(Long teamId);

    Optional<Member> findById(Long id);
}

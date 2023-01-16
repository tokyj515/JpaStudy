package com.example.demo.team_member_class.repository;


import com.example.demo.team_member_class.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {




    interface MyTeam{
        String getTeamName();
        int getMemberNum();
    }





}

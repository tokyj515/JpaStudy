package com.example.demo.member;


import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetMemberRes {

    private String name;
    private String teamName;
}

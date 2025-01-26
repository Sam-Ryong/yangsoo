package com.example.demo.controller;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberRegisterDTO;
import com.example.demo.repository.member.MemberRepository;
import com.example.demo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public boolean register(@RequestBody MemberRegisterDTO member){
        Member newMember = memberService.register(member);
        if (newMember != null){
            return true;
        }
        else{
            return false;
        }
    }

}

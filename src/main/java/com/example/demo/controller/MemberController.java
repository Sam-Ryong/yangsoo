package com.example.demo.controller;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberInputDTO;
import com.example.demo.domain.member.MemberLoginDTO;
import com.example.demo.domain.member.MemberRegisterDTO;
import com.example.demo.service.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public Member register(@RequestBody MemberRegisterDTO member) {
        return memberService.register(member);
    }

    @PostMapping("/login")
    public Optional<Member> login(@RequestBody MemberLoginDTO memberLoginDTO, HttpServletRequest request) {

        Optional<Member> member = memberService.login(memberLoginDTO);
        if (member.isEmpty()) {
            return Optional.empty();
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member.get());
        return member;
    }
    @PostMapping("/input")
    public boolean input(@RequestBody MemberInputDTO memberInputDTO, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member loginMember = (Member) session.getAttribute("loginMember");
        String input = memberInputDTO.getProfile();
        return memberService.input(loginMember.getEmail(), input).isPresent();
    }

    @GetMapping("/my-info")
    public Optional<Member> myInfo(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member loginMember = (Member) session.getAttribute("loginMember");
        return memberService.findByEmail(loginMember.getEmail());
    }

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return true;
    }


}

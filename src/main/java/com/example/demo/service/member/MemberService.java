package com.example.demo.service.member;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberLoginDTO;
import com.example.demo.domain.member.MemberRegisterDTO;

import java.util.Optional;

public interface MemberService {

    Member register(MemberRegisterDTO member);
    Optional<Member> login(MemberLoginDTO member);
    Member logout();

    Optional<Member> findByEmail(String email);

    Optional<Member> input(String email, String input);
}

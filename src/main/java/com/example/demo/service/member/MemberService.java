package com.example.demo.service.member;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberLoginDTO;
import com.example.demo.domain.member.MemberRegisterDTO;

public interface MemberService {

    Member register(MemberRegisterDTO member);
    Member login(MemberLoginDTO member);
    Member logout();
}

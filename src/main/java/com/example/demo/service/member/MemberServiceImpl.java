package com.example.demo.service.member;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberLoginDTO;
import com.example.demo.domain.member.MemberRegisterDTO;
import com.example.demo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public Member register(MemberRegisterDTO member) {
        if (member.getEmail().contains("@khu.ac.kr")) {
            Member newMember = new Member();
            newMember.setName(member.getName());
            newMember.setEmail(member.getEmail());
            return memberRepository.save(newMember);
        }
        else {
            return null;
        }
    }

    @Override
    public Optional<Member> login(MemberLoginDTO member) {
        Optional<Member> memberFound = memberRepository.findByEmail(member.getEmail());
        if (memberFound.isEmpty()){
            if (member.getEmail().contains("@khu.ac.kr")) {
                Member newMember = new Member();
                newMember.setName(member.getName());
                newMember.setEmail(member.getEmail());
                memberRepository.save(newMember);
            }
            else {
                return Optional.empty();
            }
        }

        return memberRepository.findByEmail(member.getEmail());
    }

    @Override
    public Member logout() {
        return null;
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public Optional<Member> input(String email, String input) {
        return memberRepository.input(email, input);
    }


}

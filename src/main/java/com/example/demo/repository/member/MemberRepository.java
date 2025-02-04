package com.example.demo.repository.member;

import com.example.demo.domain.member.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByEmail(String email);

    Optional<Member> increaseCount(String email);

    Optional<Member> input(String email, String input);

}

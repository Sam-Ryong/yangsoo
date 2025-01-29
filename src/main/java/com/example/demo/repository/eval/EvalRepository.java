package com.example.demo.repository.eval;

import com.example.demo.domain.member.Member;

import java.util.Optional;

public interface EvalRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByEmail(String email);

}

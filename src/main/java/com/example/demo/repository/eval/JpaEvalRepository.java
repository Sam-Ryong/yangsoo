package com.example.demo.repository.eval;

import com.example.demo.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaEvalRepository implements EvalRepository {

    private final SpringDataJpaEvalRepository repository;

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.empty();
    }
}

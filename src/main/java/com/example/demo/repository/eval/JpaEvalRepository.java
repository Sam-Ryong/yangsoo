package com.example.demo.repository.eval;

import com.example.demo.domain.eval.Eval;
import com.example.demo.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaEvalRepository implements EvalRepository {

    private final SpringDataJpaEvalRepository repository;

    @Override
    public Eval save(Eval eval) {
        return repository.save(eval);
    }

    @Override
    public Optional<Eval> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Eval> findByEmail(String email) {
        return repository.findByEmailLike(email);
    }
}

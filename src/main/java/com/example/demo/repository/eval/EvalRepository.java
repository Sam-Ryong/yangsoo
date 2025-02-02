package com.example.demo.repository.eval;

import com.example.demo.domain.eval.Eval;
import com.example.demo.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface EvalRepository {

    Eval save(Eval eval);

    Optional<Eval> findById(Long id);

    List<Eval> findByEmail(String email);

}

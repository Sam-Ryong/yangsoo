package com.example.demo.repository.eval;

import com.example.demo.domain.eval.Eval;
import com.example.demo.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaEvalRepository extends JpaRepository<Eval,Long> {

    List<Eval> findByEmailLike(String email);
}

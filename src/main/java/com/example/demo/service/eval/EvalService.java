package com.example.demo.service.eval;

import com.example.demo.domain.eval.Eval;

import java.util.List;

public interface EvalService {

    Eval eval(String profile, String name, String email);

    List<Eval> getMyEval(String email);
}

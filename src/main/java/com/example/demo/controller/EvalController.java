package com.example.demo.controller;

import com.example.demo.domain.eval.Eval;
import com.example.demo.domain.eval.EvalDTO;
import com.example.demo.domain.member.Member;
import com.example.demo.service.eval.EvalService;
import com.example.demo.service.eval.GptService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EvalController {

    private final EvalService evalService;
    @PostMapping("/eval")
    public Eval evaluate(@RequestBody EvalDTO evalDTO){

        return evalService.eval(evalDTO.getProfile(), evalDTO.getName(), evalDTO.getEmail());

    }

    @GetMapping("/my-eval")
    public List<Eval> getMyEval(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member loginMember = (Member) session.getAttribute("loginMember");
        String email = loginMember.getEmail();
        System.out.println(email);

        return evalService.getMyEval(email);
    }

}

package com.example.demo.service.eval;

import com.example.demo.domain.eval.Eval;
import com.example.demo.domain.member.Member;
import com.example.demo.repository.eval.EvalRepository;
import com.example.demo.repository.member.MemberRepository;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvalServiceImpl implements EvalService {

    private final EvalRepository evalRepository;
    private final MemberRepository memberRepository;
    private final ChatgptService chatgptService;

    @Override
    public Eval eval(String profile, String name, String email) {

        String gptResponse = chatgptService.sendMessage(profile);
        Eval eval = new Eval();
        eval.setName(name);
        eval.setEmail(email);
        eval.setInput(profile);
        eval.setCreatedAt(LocalDateTime.now());
        eval.setEval(gptResponse);
        memberRepository.increaseCount(email);
        evalRepository.save(eval);

        return eval;
    }

    @Override
    public List<Eval> getMyEval(String email) {
        return evalRepository.findByEmail(email);
    }
}

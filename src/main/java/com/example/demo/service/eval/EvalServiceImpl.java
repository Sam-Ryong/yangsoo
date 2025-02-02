package com.example.demo.service.eval;

import com.example.demo.domain.eval.Eval;
import com.example.demo.repository.eval.EvalRepository;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvalServiceImpl implements EvalService {

    private final EvalRepository repository;
    private final ChatgptService chatgptService;

    @Override
    public Eval eval(String profile, String name, String email) {

        String gptResponse = chatgptService.sendMessage(profile);
        Eval eval = new Eval();
        eval.setName(name);
        eval.setEmail(email);
        eval.setCreatedAt(LocalDateTime.now());
        eval.setEval(gptResponse);
        repository.save(eval);
        return eval;
    }

    @Override
    public List<Eval> getMyEval(String email) {
        return repository.findByEmail(email);
    }
}

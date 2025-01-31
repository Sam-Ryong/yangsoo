package com.example.demo.controller;

import com.example.demo.service.eval.GptService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EvalController {

    private final GptService chatService;
    private final ChatgptService chatgptService;
    @PostMapping("/eval")
    public String test(@RequestBody String question){
        System.out.println(question);
        return chatService.getChatResponse(question);

    }
}

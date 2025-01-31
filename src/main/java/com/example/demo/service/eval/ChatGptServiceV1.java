package com.example.demo.service.eval;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGptServiceV1 implements GptService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String prompt) {
        return chatgptService.sendMessage(prompt);
    }

}

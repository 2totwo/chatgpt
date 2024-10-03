package com.example.service.adoption;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatGptController {

    private final ChatClient chatClient;

    @GetMapping("/chat-gpt-v1")
    public String chatGptV1(@RequestParam String msg) {
        return chatClient
                .prompt()
                .user(msg)
                .call()
                .content();
    }

    @GetMapping("/chat-gpt-v2")
    public String chatGptV2(@RequestParam String msg) {
        return chatClient
                .prompt()
                .system("개발자가 되기 위해 공부하는 학생들이 한 질문이야. 이해하기 쉽게 잘 알려줘")
                .user(msg)
                .call()
                .content();
    }
}
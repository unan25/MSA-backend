package com.example.itemservice.util;

import com.example.itemservice.dto.RequestCreateItemDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public String getTestMessage(String message) throws JsonProcessingException {
        // 메시지에 심는것
        System.out.println("큐에서 뽑아낸 메시지 : " + message);
        return message;
    }
}

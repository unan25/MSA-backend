package com.example.itemservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    //멤버 변수로 RabbitTemplate을 완성
    private final RabbitTemplate rabbitTemplate;

    //rabbitTemplate.convertAndSend("큐 이름", 보낼 데이터);
    public void sendTestMessage(String message) {
        rabbitTemplate.convertAndSend("ITEM_CREATE_QUEUE", message);
    }
}

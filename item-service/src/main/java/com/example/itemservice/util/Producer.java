package com.example.itemservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    //멤버 변수로 RabbitTemplate을 완성
    private final RabbitTemplate rabbitTemplate;

}

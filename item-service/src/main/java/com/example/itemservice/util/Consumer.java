package com.example.itemservice.util;

import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;

    private final ItemService itemService;

//    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
//    public String getTestMessage(String message) throws JsonProcessingException {
//        // 메시지에 심는것
//        System.out.println("큐에서 뽑아낸 메시지 : " + message);
//        return message;
//    }

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public void createItem(String message) throws JsonProcessingException{
        //ObjectMapper.readValue("String 형식인 Json", 목적 객체.class);
        RequestCreateItemDto requestCreateItemDto = objectMapper.readValue(message, RequestCreateItemDto.class);
        // service에서 DTO를 입력받아 DB에 INSERT해주는 로직을 호출해주세요.
        itemService.createItem(requestCreateItemDto);
    }
}

package com.example.itemservice.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "#{myTopic1.name}", groupId = "group1")
    public void consumeMyTopic1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
        log.info("[consume message]: {} from partition: {}", message, partition);
    }

    @KafkaListener(topics = "#{myTopic2.name}", groupId = "group1")
    public void consumeMyTopic2(@Payload String message,
                                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        log.info("[topic2 consume message]: {} from partition: {}", message, topic);
    }
}

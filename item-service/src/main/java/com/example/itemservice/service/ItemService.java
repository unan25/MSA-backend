package com.example.itemservice.service;

import com.example.itemservice.domain.Item;
import com.example.itemservice.domain.Order;
import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.dto.ResponseOrderByItemDto;
import com.example.itemservice.feignclient.OrderFeignClient;
import com.example.itemservice.repository.ItemRepository;
import com.example.itemservice.util.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final OrderFeignClient orderFeignClient;
    private final Producer producer;
    // 직렬화, 역직렬화 담당 라이브러리
    private final ObjectMapper objectMapper;

    public void createItem(RequestCreateItemDto requestCreateItemDto) {
        itemRepository.save(requestCreateItemDto.toEntity());
    }

    public ResponseOrderByItemDto findOrderByItem(String productId) {
        // 1. 특정 아이템을 가져옵니다.
        Item item = itemRepository.findItemByProductId(productId)
                .orElseThrow(() -> new RuntimeException("해당 아이템은 없습니다"));
        // ResponseDTO 로 변경하는 코드 추가하기!!
        ResponseOrderByItemDto itemDto = new ResponseOrderByItemDto(item);
        // 2. feign 클라이언트를 이용해서 특정 유저의 구매목록을 가져옵니다.
        List<Order> orderList = orderFeignClient.getOrdersByItemId(productId);
        System.out.println("orderList : " + orderList);
        // 3. 세터로 합쳐줍니다.
        itemDto.setOrderList(orderList);
        // 4. 합쳐준걸 리턴해주세요.
        return itemDto;
    }

    public void publishTestMessage(String message) {
        producer.sendTestMessage(message);
    }

    public void publishCreateItemMessage(RequestCreateItemDto requestCreateItemDto)
            throws JsonProcessingException {
        // 받아온 DTO를 json(String)으로 직렬화
        // objectMapper.writeValueAsString => 예외 처리 필요 : throws or try/catch문 사용
        String message = objectMapper.writeValueAsString(requestCreateItemDto);
        producer.sendCreateItemMessage(message);
    }

}


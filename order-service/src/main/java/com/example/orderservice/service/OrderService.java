package com.example.orderservice.service;

import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.RequestCreateOrderDto;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(RequestCreateOrderDto requestCreateOrderDto){
        Order order = requestCreateOrderDto.toEntity();
        orderRepository.save(order);
    }

    // userID를 입력하면 Order 리스트를 넘겨주는 메서드 호출을 통해 리턴
    public Optional<List<Order>> getOrderListByUserId(String userId) {
        // 내가 작성한 코드
//        Optional<List<Order>> optionalOrders = orderRepository.findOrderByUserId(userId);
//        return optionalOrders;
        return orderRepository.findOrderByUserId(userId);
    }
}

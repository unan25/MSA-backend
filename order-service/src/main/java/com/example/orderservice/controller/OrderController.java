package com.example.orderservice.controller;

import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.RequestCreateOrderDto;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("health-check")
    public String healthCheck(){
        return "order-service server is available";
    }

    @PostMapping("orders")
    public ResponseEntity<?> createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto){
        orderService.createOrder(requestCreateOrderDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    // userId를 이용해 해당 유저 OrderList 조회
    @GetMapping("orders/{userId}/users")
    public ResponseEntity<?> getOrderListByUserId(@PathVariable String userId){
        List<Order> orderList = orderService.getOrderListByUserId(userId)
                .orElseThrow(()-> new RuntimeException("없는 유저 아이디로 조회하셨습니다."))
                .stream().toList();
        return ResponseEntity.ok(orderList);
        // ok 정적 메소드 new 필요 x
    }
    @GetMapping("orders/{productId}/products")
    public ResponseEntity<?> getOrderListByProductId(@PathVariable String productId){
        List<Order> orderList = orderService.getOrderListByProductId(productId)
                .orElseThrow(() -> new RuntimeException("없는 아이템 아이디로 조회하셨습니다."))
                .stream().toList();
        System.out.println(orderList);
        return ResponseEntity.ok(orderList);
    }
}

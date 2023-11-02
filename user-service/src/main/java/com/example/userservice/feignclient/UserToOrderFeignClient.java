package com.example.userservice.feignclient;

import com.example.userservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE", path = "order-service") //요청 받는 곳
public interface UserToOrderFeignClient {

    // order-service로 유레카에 등록된 서비스의 orders/{userId}로 호출을 넣으면 요청을 처리해준다.
    @GetMapping("/orders/{userId}") // order 해당 컨트롤러 엔드 포인트 패턴
    public List<Order> getOrderListByUserId(@PathVariable String userId);

    // domain에 Order 데이터 받아주는 용도로 필드 생성
}

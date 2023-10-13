package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // pre filter는 그냥 내부에 실행문으로 작성하면 돌아감
            System.out.println("Custom preFilter : " + request.getId());

            // post filter는 return 구문 속에 코드를 작성해서 만든다.
            // Mono : 비동기에서 동기로 단일 값을 전달해주는 역할
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Custom postFilter : " + response.getStatusCode());
            }));
        };
    }

    // 응집도를 높이기 위해 내부 클래스 방식으로 구현
    public static class Config {

    }

}

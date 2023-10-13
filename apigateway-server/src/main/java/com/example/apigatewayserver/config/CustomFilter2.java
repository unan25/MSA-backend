package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter2 extends AbstractGatewayFilterFactory<CustomFilter2.Config> {

    public CustomFilter2() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            System.out.println("커스텀2 preFilter : " + request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("커스텀2 postFilter : " + response.getStatusCode());
            }));
        });
    }

    /*
     OrderedGatewayFilter
     - 실행 순번을 지정할 수 있다.
     */
//    @Override
//    public GatewayFilter apply(Config config) {
//        GatewayFilter gatewayFilter = new OrderedGatewayFilter((exchange, chain) -> {
//
//        }, Ordered.LOWEST_PRECEDENCE); // 순위 (숫자가 낮은 순) 별로 실행
//    }


    public static class Config {

    }
}

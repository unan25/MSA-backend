package com.example.apigatewayserver.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            System.out.println("글로벌 필터 default message : " + config.getMessage());

            // boolean 값으로 주면서 yml 에서 원할 때 사용할 수 있음
            if (config.isPre()) {
                System.out.println("글로벌 preFilter : " + request.getId());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPost()) {
                    System.out.println("글로벌 postFilter : " + response.getStatusCode());
                }
            }));
        });
    }

    @Getter
    @Setter
    public static class Config {
        // 설정파일에서 넘겨주는 인자 값을 받을 수 있도록 Config 이너클래스에 멤버변수 선언
        private String message;
        private boolean pre;
        private boolean post;
    }
}

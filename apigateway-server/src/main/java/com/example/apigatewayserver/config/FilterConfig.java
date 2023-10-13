package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    
    // 게이트웨이를 통해 들어갔을 때만 필터가 적용
    // ex) localhost8000 으로 들어가야 적용

    // Bean만 주석 처리하면 해당 메서드가 리턴하는 빈이 적재되지 않으므로 설정도 초기화됨
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
//        return routeLocatorBuilder.routes()
//                .route(r -> r.path("/first-service/**")
//                        .filters(f -> f.addRequestHeader("f-req", "f-req-v")
//                                .addResponseHeader("f-res", "f-res-v"))
//                        .uri("http://localhost:8001/")
//                ) // 개별 라우팅 정보를 등록하는 route() 메서드
//                .route(r -> r.path("/second-service/**")
//                        .filters(f -> f.addRequestHeader("s-req", "s-req-v")
//                                .addResponseHeader("s-res", "s-res-v"))
//                        .uri("http://localhost:8002/")
//                )
//                // 모든 설정이 끝나면
//                .build(); // 빌더 패턴 종료
//    }
    
}

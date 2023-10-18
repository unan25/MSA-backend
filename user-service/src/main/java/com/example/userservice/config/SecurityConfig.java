package com.example.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests() // 인증, 인가 설정을 시작합니다.
//                .requestMatchers("/user-service/health-check2").permitAll()// 해당 주소는 인증, 인가 없이 접속 가능하며
//                .anyRequest().hasRole("ADMIN")
//                .and()// 그리고 다음 설정으로
//                .csrf()
//                .disable()
//                .build();
        // 위 코드를 람다식을 사용한 코드로 바꿔서 deprecated 요소를 없애보자.

        // 내가 짠거
//        http
//                .authorizeHttpRequests((authorizeHttpRequests) ->
//                        authorizeHttpRequests
//                                .requestMatchers("/user-service/health-check").permitAll()
//                                .anyRequest().hasRole("ADMIN")
//                );
//
//        return http.build();

        // 정답
        return http
                // 변수명이 너무 길어 가독성이 해치지 않는 쪽에서 줄여도 된다. ex) a -> a 도 가능하나 가독성을 해친다.
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/**").permitAll()
                        .anyRequest().hasRole("ADMIN"))
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer
                        .disable())
                .build();
    }

    // 암호화 비밀번호 저장을 위한 BCryptEncoder 빈 생성
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

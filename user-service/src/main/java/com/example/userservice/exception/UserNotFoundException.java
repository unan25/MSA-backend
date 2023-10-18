package com.example.userservice.exception;

/*
uuid로 회원을 조회 예외처리
 */
public class UserNotFoundException extends RuntimeException {

    // 생성자
    public UserNotFoundException(String message) {
        super(message);
    }
}

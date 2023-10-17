package com.example.userservice.controller;

import com.example.userservice.dto.RequestCreateUserDTO;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("health-check")
    public String healthCheck() {
        return "server is available !";
    }

    @PostMapping("users")
    public ResponseEntity<?> createUser(@Valid @RequestBody RequestCreateUserDTO usetDto) {
        System.out.println(usetDto);
        return ResponseEntity.ok("회원 가입 완료 !");
    }


}

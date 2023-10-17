package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.dto.RequestCreateUserDTO;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> createUser(@Valid @RequestBody RequestCreateUserDTO userDto) {
        System.out.println(userDto);
        userService.createUser(userDto);
        return ResponseEntity.ok("회원 가입 완료 !");
    }

    // uuid로 회원 조회
    @GetMapping("users/{uuid}")
    public ResponseEntity<?> findUserByUuid(@PathVariable String uuid){
        User user = userService.findUserByUuid(uuid);
        return ResponseEntity.ok(user);
    }

}

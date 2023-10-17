package com.example.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @Builder @ToString
// 참조 테이블이 없으면 ToString 가능 / 무자별로 사용한다면 순환참조 발생
public class RequestCreateUserDTO {

     @Email
     private String email;

     @Size(min = 8, max = 20, message = "비밀번호는 최소 8글자이고, 최대 20글자입니다.")
     private String pw;

     @NotNull
     private String name;
}

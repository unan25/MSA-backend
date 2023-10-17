package com.example.userservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter @AllArgsConstructor @Builder
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String userId;

    private String encPw;

    private String uuid;

    private LocalDateTime createAt;
}

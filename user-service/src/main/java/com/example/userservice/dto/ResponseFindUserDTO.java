package com.example.userservice.dto;

import com.example.userservice.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseFindUserDTO {

    private Long id;

    private String email;

    private String name;

    private String userId;

    private String uuid;

    public ResponseFindUserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
        this.uuid = user.getUuid();
    }
}

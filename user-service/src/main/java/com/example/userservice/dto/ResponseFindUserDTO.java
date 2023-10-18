package com.example.userservice.dto;

import com.example.userservice.domain.Order;
import com.example.userservice.domain.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    
    // 필요하다면 구매내역을 같이 가져올 수 있도록 처리
    private List<Order> orderList;

    public ResponseFindUserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
        this.uuid = user.getUuid();
    }
}

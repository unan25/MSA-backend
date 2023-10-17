package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.RequestCreateUserDTO;
import com.example.userservice.dto.ResponseFindUserDTO;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public void createUser(RequestCreateUserDTO userDto) {
        // dto를 entity로 변경해주는 작업이 필요
        User user = userDto.toEntity();

        userRepository.save(user);
    }

    // uuid로 회원 조회
//    public User findUserByUuid(String uuid){
//        User user = userRepository.findUserByUuid(uuid);
//
//        return user;
//    }

    // ResponseFindUserDto를 통해 uuid로 회원 조회
    public ResponseFindUserDTO findUserByUuid(String uuid){
        User user = userRepository.findUserByUuid(uuid);

        return new ResponseFindUserDTO(user);
    }

}

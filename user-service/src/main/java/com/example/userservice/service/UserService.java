package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.RequestCreateUserDTO;
import com.example.userservice.dto.ResponseFindUserDTO;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if(user == null)
            throw new UserNotFoundException("해당 유저는 존재하지 않습니다.");

        ResponseFindUserDTO dto = new ResponseFindUserDTO(user);
        dto.setOrderList(List.of());

        return dto;
    }
    
    // 회원 전체 조회
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

}

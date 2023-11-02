package com.example.userservice.service;

import com.example.userservice.domain.Order;
import com.example.userservice.domain.User;
import com.example.userservice.dto.RequestCreateUserDTO;
import com.example.userservice.dto.ResponseFindUserDTO;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.feignclient.UserToOrderFeignClient;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final UserToOrderFeignClient userToOrderFeignClient;

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

    public ResponseFindUserDTO findUserOrderList(String userId){
        // 1. 특정 유저 아이디를 가져오기
        User user = userRepository.findByUserId(userId);
        ResponseFindUserDTO userDto = new ResponseFindUserDTO(user);
        log.info("아이디 기반으로 유저 정보 얻어오기 : ", userDto);
        // 2. feign 클라이언트를 이용해서 특정 유저의 구매목록 가져오기
        List<Order> orderList = userToOrderFeignClient.getOrderListByUserId(userId);
        log.info("아이디 기반으로 주문 정보 얻어오기 : ", orderList);
        // 3. 세터로 합쳐주기
        userDto.setOrderList(orderList);
        log.info("Setter 성공 여부 확인 : ", userDto);
        // 4. 합쳐준걸 리턴하기
        return userDto;
    }

}

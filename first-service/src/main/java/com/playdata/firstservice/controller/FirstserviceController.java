package com.playdata.firstservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service")// gateway서버의 predicates의 식별 주소를 추가해야 한다.
public class FirstserviceController {

//    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // Get, Post 두 가지의 역할 가능하다는 예시
    
     @RequestMapping(value = "hello", method = RequestMethod.GET)
//    @GetMapping
    public String hello() {
        return "Hello First-Service";
    }

    @GetMapping("/header-check")
    public String headerCheck(@RequestHeader("f-req") String headerMsg){
         return headerMsg;
    }
}

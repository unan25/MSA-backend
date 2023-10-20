package com.playdata.firstservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service")// gateway서버의 predicates의 식별 주소를 추가해야 한다.
@RequiredArgsConstructor
public class FirstserviceController {

    private final Environment env;

//    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // Get, Post 두 가지의 역할 가능하다는 예시

    @RequestMapping(value = "hello", method = RequestMethod.GET)
//    @GetMapping
    public String hello() {
        return "Hello First-Service";
    }

    @GetMapping("/header-check")
    public String headerCheck(@RequestHeader("f-req") String headerMsg) {
        return headerMsg;
    }

    // 포트 번호, config 감지
    @GetMapping("port-check")
    public String portCheck() {
        return "Local Server Port : "
                + env.getProperty("local.server.port")
                + " / "
                + "Config Value : "
                + env.getProperty("test.value");
    }

}

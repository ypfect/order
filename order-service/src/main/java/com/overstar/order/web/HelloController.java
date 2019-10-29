package com.overstar.order.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
//    @SentinelResource("hello")
    public String hello() {
        return "Hello Web MVC";
    }
}
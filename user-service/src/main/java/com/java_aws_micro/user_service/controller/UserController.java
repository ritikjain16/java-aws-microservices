package com.java_aws_micro.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_aws_micro.user_service.feignClient.OrderClient;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private OrderClient orderClient;

    @GetMapping("/a")
    public String test() {

        return "User Service is working.";
    }

    @GetMapping("/")
    public String getUsers() {

        String res = orderClient.getOrdersByUserId("123");

        return "User Service is working. Orders: " + res;
    }

}

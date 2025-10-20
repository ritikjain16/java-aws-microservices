package com.java_aws_micro.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_aws_micro.order_service.feignClient.UserClient;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/a")
    public String test() {

        return "Order Service is working.";
    }

    @GetMapping("/{userId}")
    public String getOrdersByUserId(@PathVariable("userId") String userId) {
        String res = userClient.getUsers();
        return "Orders for user with ID: " + userId + ". User Service says: " + res;
    }

}

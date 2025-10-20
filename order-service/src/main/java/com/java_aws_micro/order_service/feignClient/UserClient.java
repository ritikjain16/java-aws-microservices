package com.java_aws_micro.order_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/api/user/b")
    public String getUsers();
}

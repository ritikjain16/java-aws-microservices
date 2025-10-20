package com.java_aws_micro.user_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderClient {
    @GetMapping("/api/orders/{userId}")
    String getOrdersByUserId(@PathVariable("userId") String userId);
}

package com.beat.chen.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("provider")
public interface TestService {

    @RequestMapping("/user")
    public String getUser(@RequestParam("id") String id);
}

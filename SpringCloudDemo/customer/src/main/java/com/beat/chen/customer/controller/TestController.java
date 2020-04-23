package com.beat.chen.customer.controller;


import com.beat.chen.customer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TestController {
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private TestService testService;
    @RequestMapping("/info")
    public String getInfo(){
        List<ServiceInstance> customer = client.getInstances("customer");

        return "ip: "+customer.get(0).getHost()+"service_id："+customer.get(0).getInstanceId();
    }

    @RequestMapping("/user")
    public String getUser(String id){
        String user = testService.getUser(id);
        return user;
    }
}

package com.beat.chen.product.controller;

import com.beat.chen.baseapi.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient client;
    @RequestMapping("/info")
    public String getInfo(){
        List<ServiceInstance> customer = client.getInstances("customer");

        return "ip: "+customer.get(0).getHost()+"service_id："+customer.get(0).getInstanceId();
    }

    @RequestMapping("/user")
    public Users getUse(String id){
        Users user = new Users();
        user.setId(id);
        user.setName("张三");
        user.setAge(10);
        return user;
    }
}

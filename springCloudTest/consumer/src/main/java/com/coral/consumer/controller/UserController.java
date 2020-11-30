package com.coral.consumer.controller;

import com.coral.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultError")//全局性降级服务
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    //@HystrixCommand(fallbackMethod = "queryError")每个方法单个的降级服务
    @HystrixCommand
    @RequestMapping("/{id}")
    public String queryById(@PathVariable Long id){
        //return restTemplate.getForObject("http://localhost:9901/user/"+id,String.class);正常情况下
        return restTemplate.getForObject("http://api/server/user/"+id,String.class);//加入网关后
    }

    public String queryError(@PathVariable Long id){
        return "网络拥挤";
    }

    public String defaultError(){
        return "默认：网络拥挤";
    }

    @RequestMapping("/add")
    public boolean add(){
        //return restTemplate.getForObject("http://localhost:9901/user/"+id,String.class);正常情况下
        return restTemplate.getForObject("http://api/server/user/add",Boolean.class);//加入网关后
    }


    @PostMapping("/UserAdd")
    @ApiOperation("添加用户的接口")
    public int addUser(@RequestBody User user) {
        return 1;
    }
}

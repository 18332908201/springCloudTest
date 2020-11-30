package com.coral.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//Eureka客户端
@EnableDiscoveryClient
//开启Zuul网关
//当前应用是一个Zuul微服务网关。会在Eureka注册中心中注册当前服务。并发现其他的服务。
@EnableZuulProxy

public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}

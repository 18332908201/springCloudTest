package com.coral.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//exclude，排除此类的AutoConfig，即禁止 SpringBoot 自动注入数据源配置。
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//开启Eureka服务
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}

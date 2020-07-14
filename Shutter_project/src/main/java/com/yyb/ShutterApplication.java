package com.yyb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync //开启异步调用
@MapperScan(basePackages = {"com.yyb.mapper"})
public class ShutterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShutterApplication.class,args);
    }
}

package com.wlh.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EduSystemMain8888 {
    public static void main(String[] args) {
        SpringApplication.run(EduSystemMain8888.class,args);
        log.info("访问网址：localhost:8888/login" );
    }
}

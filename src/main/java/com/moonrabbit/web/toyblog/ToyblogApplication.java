package com.moonrabbit.web.toyblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启定时任务
@EnableScheduling
// 开启缓存
//@EnableCaching
public class ToyblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyblogApplication.class, args);
    }

}

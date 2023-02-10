package com.xiao.eatontime;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EatontimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatontimeApplication.class, args);
        log.info("项目启动成功");
    }

}

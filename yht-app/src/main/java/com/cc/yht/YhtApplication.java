package com.cc.yht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.cc.yht.provider.**.dao")
public class YhtApplication {
    public static void main(String[] args) {
        SpringApplication.run(YhtApplication.class);
    }
}

package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhang pan
 * @Description 类描述
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.demo.mapper"})
public class PageHelperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageHelperApplication.class,args);
    }
}

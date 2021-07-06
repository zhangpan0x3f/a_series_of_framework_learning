package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

/**
 * @author : zhang pan
 * @date : 5:21 下午 2021/6/4
 * 描述：
 */
@SpringBootApplication
public class JPAApplication {

    private static final Logger logger = LoggerFactory.getLogger(JPAApplication.class);

    public static void main(String[] args) {
        logger.info("JPA application start🥰");
        SpringApplication.run(JPAApplication.class,args);
    }
}

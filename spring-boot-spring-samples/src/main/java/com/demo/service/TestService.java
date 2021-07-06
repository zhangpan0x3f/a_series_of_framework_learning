package com.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author : zhang pan
 * @date : 4:51 下午 2021/7/6
 * 描述：
 */
@Service
public class TestService {

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans/BeanDemo01.xml");
        Object user1 = ac.getBean("user1");
        System.out.println(user1);
    }

}

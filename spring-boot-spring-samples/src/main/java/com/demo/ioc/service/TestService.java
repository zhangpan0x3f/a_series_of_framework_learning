package com.demo.ioc.service;

import com.demo.ioc.model.Address;
import com.demo.ioc.model.Person;
import com.demo.ioc.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
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
        //ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans/BeanDemo01.xml");
        User user1 = ac.getBean("user7", User.class);
        System.out.println(user1);
        //获取一个bean的运行时类型
        System.out.println(ac.getType("user6"));
    }

    @Test
    public void test1(){
//        ApplicationContext ac = new GenericGroovyApplicationContext("bean.groovy");
//        User user = ac.getBean("user", User.class);
//        System.out.println(user);
        System.out.println("hello world");
    }

    @Test
    public void test2(){
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("beans/BeanDemo01.xml");
        context.refresh();
    }

    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans/BeanDemo02.xml");
        Person person1 = ac.getBean("person1", Person.class);
        System.out.println(person1);
    }

    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans/BeanDemo02.xml");
        Address address2 = ac.getBean("address2", Address.class);
        System.out.println(address2);
    }

    @Test
    public void test5(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans/BeanDemo02.xml");
        Address address3 = ac.getBean("address3", Address.class);
        System.out.println(address3);
    }

    @Test
    public void test6(){
        //循环依赖
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans/BeanDemo03.xml");
//        System.out.println(ac.getBean("a"));
//        System.out.println(ac.getBean("b"));
    }

}

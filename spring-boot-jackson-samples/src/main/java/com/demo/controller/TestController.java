package com.demo.controller;

import com.demo.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhang pan
 * @Description 类描述
 */
@RestController
public class TestController {

    @GetMapping("/mybean")
    public MyBean mybean(){
        MyBean zs = new MyBean(1, "zs");
        return zs;
    }

    @GetMapping("/rawbean")
    public RawBean rawbean(){
        return new RawBean("zs","1231");
    }

    @GetMapping("/enum")
    public TypeEnumWithValue typeEnumWithValue(){
        return TypeEnumWithValue.TYPE1;
    }

    @GetMapping("/userwithroot")
    public String userWithRoot() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return mapper.writeValueAsString(new UserWithRoot(1, "zs"));
    }

    @GetMapping("/eventWithSerializer")
    public EventWithSerializer eventWithSerializer(){
        return new EventWithSerializer("time",new Date());
    }

    @GetMapping("/beanWithCreator")
    public BeanWithCreator beanWithCreator(){
        return new BeanWithCreator(1,"zs");
    }

    @GetMapping("/test1")
    public String test1() throws JsonProcessingException {
        UserWithIdentity user = new UserWithIdentity(1, "John");
        ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        List<ItemWithIdentity> l = new ArrayList<>();
        l.add(item);
        user.setUserItems(l);

        String result = new ObjectMapper().writeValueAsString(item);
        return result;
    }

}

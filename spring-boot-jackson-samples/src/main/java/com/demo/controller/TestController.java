package com.demo.controller;

import com.demo.entity.MyBean;
import com.demo.entity.RawBean;
import com.demo.entity.TypeEnumWithValue;
import com.demo.entity.UserWithRoot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

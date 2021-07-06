package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;


/**
 * @author zhang pan
 * @Description 类描述
 */
public class BeanWithCreator {

    public int id;

    public String name;

    /***
     * 可以使用@JsonCreator注解来调整反序列化中使用的构造函数/工厂
     * @param id
     * @param name
     */
    @JsonCreator
    public BeanWithCreator(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanWithCreator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";

        BeanWithCreator bean = new ObjectMapper()
                .readerFor(BeanWithCreator.class)
                .readValue(json);
        System.out.println(bean);
    }

}
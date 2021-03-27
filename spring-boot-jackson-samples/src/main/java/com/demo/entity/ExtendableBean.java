package com.demo.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
/**
 * @author zhang pan
 * @Description 类描述
 */

public class ExtendableBean {

    /**
     * 名称
     */
    @JsonSetter
    private String name;

    /**
     * 属性
     */
    private Map<String,String> properties = new HashMap<>();


    /**
     * 在序列化时，用Map对象的键值对转成json的字段和值
     * @return
     */
    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    /***
     *反序列化时，对json中不认识的字段，统统调用JsonAnySetter注解修饰的方法去处理
     */
    @JsonAnySetter
    public void add(String key,String value){
        properties.put(key,value);
    }

    @Override
    public String toString() {
        return "ExtendableBean{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json
                = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        ExtendableBean bean = new ObjectMapper()
                .readerFor(ExtendableBean.class)
                .readValue(json);
        System.out.println(bean);
    }

}

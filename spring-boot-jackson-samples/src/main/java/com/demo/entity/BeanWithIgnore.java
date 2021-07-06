package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
//@JsonIgnoreProperties({ "id" })  //@JsonIgnoreProperties是一个类级别的注释,将忽略的一个属性或属性列表
public class BeanWithIgnore {

    /**
     * 用于标记在字段级别要忽略的属性。
     */
    @JsonIgnore
    private int id;

    private String name;

    public BeanWithIgnore(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanWithIgnore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
    }

}

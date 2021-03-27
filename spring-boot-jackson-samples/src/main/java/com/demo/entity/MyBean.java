package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author zhang pan
 * @Description 类描述
 */
@JsonPropertyOrder({ "name", "id" }) //指定属性序列化的一个顺序，这里是name先于id序列化
public class MyBean {

    private int id;

    private String name;

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    /**
     * we specify the method getTheName() as the getter method of the
     * name property of a MyBean entity
     * @return
     */
    @JsonGetter("name")
    public String getTheName() {
        return name;
    }

}

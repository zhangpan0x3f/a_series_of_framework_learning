package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zhang pan
 * @Description 类描述
 */
public enum TypeEnumWithValue {

    /**
     * id
     * name
     */
    TYPE1(1, "Type A"),
    TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    /**
     * @JsonValue 可以用在get方法或者属性字段上，一个类只能用一个，当加上@JsonValue注解是，序列化是只返回这一个字段的值
     * @return
     */
    @JsonValue
    public String getName() {
        return name;
    }

}

package com.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class EventWithSerializer {

    private String name;



    /***
     * 此注解用于属性或者getter方法上，用于在序列化时嵌入开发者自定义的代码。
     * 比如将一个Date类型的变量转换成Long类型，或是序列化一个double时在其后面限制两位小数点。
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public EventWithSerializer() {
    }

    public EventWithSerializer(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public Date getEventDate() {
        return eventDate;
    }
}

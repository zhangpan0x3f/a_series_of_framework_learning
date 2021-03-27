package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class RawBean {

    private String name;

    /***
     * The @JsonRawValue annotation can instruct Jackson to serialize a property exactly as is.
     */
    @JsonRawValue
    private String json;

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public String getJson() {
        return json;
    }
}

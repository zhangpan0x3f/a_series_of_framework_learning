package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author zhang pan
 * @Description 类描述
 */
@JsonRootName(value = "user")
public class UserWithRoot {

    private int id;

    private String name;

    public UserWithRoot() {
    }

    public UserWithRoot(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

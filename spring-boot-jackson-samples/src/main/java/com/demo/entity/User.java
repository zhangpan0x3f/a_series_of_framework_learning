package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class User {

    public int id;

    public Name name;

    public User(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    @JsonIgnoreType
    public static class Name {

        public String firstName;

        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        User.Name name = new User.Name("John", "Doe");
        User user = new User(1, name);

        String result = new ObjectMapper()
                .writeValueAsString(user);
        System.out.println(result);
    }

}

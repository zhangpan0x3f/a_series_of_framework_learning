package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class UnwrappedUser {

    private int id;

    /**
     * @JsonUnwrapped 扁平对象
     */
    @JsonUnwrapped
    public Name name;

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

    public UnwrappedUser(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Doe");
        UnwrappedUser user = new UnwrappedUser(1, name);

        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);
    }

}

package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class AliasBean {

    /**
     * @JsonAlias 在反序列化期间为属性定义一个或多个备用名称。
     */
    @JsonAlias({ "fName", "f_name" })
    private String firstName;

    private String lastName;

    @JsonSetter("fName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AliasBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
        AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);
        System.out.println(aliasBean);
    }

}

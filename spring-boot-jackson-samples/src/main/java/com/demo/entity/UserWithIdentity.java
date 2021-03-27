package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang pan
 * @Description 类描述
 */

/**
 * @JsonIdentityInfo 在对值进行序列化/反序列化时（例如，在处理无限递归类型的问题时）应使用对象标识。
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserWithIdentity {

    public int id;

    public String name;

    public List<ItemWithIdentity> userItems;

    public UserWithIdentity(int id, String name) {
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

    public List<ItemWithIdentity> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithIdentity> userItems) {
        this.userItems = userItems;
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserWithIdentity user = new UserWithIdentity(1, "John");
        ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        List<ItemWithIdentity> l = new ArrayList<>();
        l.add(item);
        user.setUserItems(l);

        String result = new ObjectMapper().writeValueAsString(item);

        System.out.println(result);

    }

}

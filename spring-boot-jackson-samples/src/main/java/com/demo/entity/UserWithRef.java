package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class UserWithRef {
    public int id;

    public String name;

    /***
     * @JsonManagedReference @JsonBackReference 批注可以处理父/子关系并解决循环。
     */
    @JsonBackReference
    public List<ItemWithRef> userItems;

    public UserWithRef(int id, String name) {
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

    public List<ItemWithRef> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithRef> userItems) {
        this.userItems = userItems;
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserWithRef user = new UserWithRef(1, "John");
        ItemWithRef item = new ItemWithRef(2, "book", user);
        List<ItemWithRef> l = new ArrayList<>();
        l.add(item);
        user.setUserItems(l);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);
    }

}
package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class ItemWithRef {

    public int id;

    public String itemName;

    @JsonManagedReference
    public UserWithRef owner;

    public ItemWithRef(int id, String itemName, UserWithRef owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public UserWithRef getOwner() {
        return owner;
    }

    public void setOwner(UserWithRef owner) {
        this.owner = owner;
    }
}
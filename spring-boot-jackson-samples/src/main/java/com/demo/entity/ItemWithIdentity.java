package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author zhang pan
 * @Description 类描述
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ItemWithIdentity {

    public int id;

    public String itemName;

    public UserWithIdentity owner;

    public ItemWithIdentity(int id, String itemName, UserWithIdentity owner) {
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

    public UserWithIdentity getOwner() {
        return owner;
    }

    public void setOwner(UserWithIdentity owner) {
        this.owner = owner;
    }
}

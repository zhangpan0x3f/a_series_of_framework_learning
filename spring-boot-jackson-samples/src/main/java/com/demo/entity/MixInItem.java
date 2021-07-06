package com.demo.entity;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class MixInItem {

    public int id;

    public String itemName;

    public User owner;

    public MixInItem(int id, String itemName, User owner) {
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "MixInItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", owner=" + owner +
                '}';
    }
}

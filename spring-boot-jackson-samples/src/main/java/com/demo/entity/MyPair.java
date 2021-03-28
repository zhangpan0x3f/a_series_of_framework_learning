package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class MyPair {

    private String first;
    private String second;

    @Override
    @JsonValue
    public String toString() {
        return first + " and " + second;
    }

    // standard getter, setters, equals, hashCode, constructors

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public static void main(String[] args) {

    }

}

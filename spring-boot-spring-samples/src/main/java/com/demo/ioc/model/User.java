package com.demo.ioc.model;

/**
 * @author : zhang pan
 * @date : 5:49 下午 2021/7/6
 * 描述：
 */
public class User {

    private String name;

    private Integer age;

    /**
     * 静态工厂方法
     * @return 返回一个User对象
     */
    public static User createUser(){
        return new User("dubbo",3);
    }

    /**
     * 实例工厂方法
     * @return
     */
    public User createInstanceUser(){
        return new User("kafka",3);
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

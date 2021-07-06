package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class Zoo {

    public Animal animal;

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    /**
     * @JsonTypeInfo 作用于类或接口，被用来处理多态类型的序列化及反序列化
     * use：定义使用哪一种类型识别码
     *      JsonTypeInfo.Id.CLASS：使用完全限定类名做识别
     *      JsonTypeInfo.Id.MINIMAL_CLASS：若基类和子类在同一包类，使用类名(忽略包名)作为识别码
     *      JsonTypeInfo.Id.NAME：一个合乎逻辑的指定名称
     *      JsonTypeInfo.Id.CUSTOM：自定义识别码
     *      JsonTypeInfo.Id.NONE：不使用识别码
     * include：指定识别码是如何被包含进去的，它有下面几个可选值
     *      JsonTypeInfo.As.PROPERTY：作为数据的兄弟属性
     *      JsonTypeInfo.As.EXISTING_PROPERTY：作为POJO中已经存在的属性
     *      JsonTypeInfo.As.EXTERNAL_PROPERTY：作为扩展属性
     *      JsonTypeInfo.As.WRAPPER_OBJECT：作为一个包装的对象
     *      JsonTypeInfo.As.WRAPPER_ARRAY：作为一个包装的数组
     * property：制定识别码的属性名称
     *
     * @JsonSubTypes: 可以用来表明这个父类的子类型有哪些
     */
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public static class Animal {
        public String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);

        String result = new ObjectMapper()
                .writeValueAsString(zoo);
        System.out.println(result);
    }

}

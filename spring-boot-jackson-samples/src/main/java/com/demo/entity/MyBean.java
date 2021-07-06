package com.demo.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
@JsonPropertyOrder({ "name", "id" }) //指定属性序列化的一个顺序，这里是name先于id序列化
@JsonInclude(JsonInclude.Include.NON_NULL)  //to exclude properties with empty/null/default values.不返回null字段数据
public class MyBean {

    private int id;

    private String name;

    @JsonCreator
    public MyBean(@JsonProperty("id") int id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    /**
     * 序列化时指定字段名
     * @return
     */
    @JsonGetter("name")
    public String getTheName() {
        return name;
    }

    /**
     * 反序列化为指定字段名
     * @param name
     */
    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

//    @JsonProperty("name")
//    public void setTheName(String name) {
//        this.name = name;
//    }
//
//    @JsonProperty("name")
//    public String getTheName() {
//        return name;
//    }

    @Override
    public String toString() {
        return "MyBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    在处理非标准的getter和setter时，让我们使用@JsonProperty对属性名称进行序列化/反序列化
//    public static void main(String[] args) throws JsonProcessingException {
//        String json = "{\"id\":1,\"name\":\"My bean\"}";
//
//        MyBean bean = new ObjectMapper()
//                .readerFor(MyBean.class)
//                .readValue(json);
//        System.out.println(bean);
//    }

    public static void main(String[] args) throws JsonProcessingException {
        MyBean bean = new MyBean(1, null);

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
    }

}

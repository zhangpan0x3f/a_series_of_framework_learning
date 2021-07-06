package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class Car {

    private String color;

    private String type;

    public Car() {
    }

    //    @JsonCreator
    public Car(/*@JsonProperty("color")*/ String color,/*@JsonProperty("type")*/ String type) {
        this.color = color;
        this.type = type;
    }

    @JsonGetter
    public String getColor() {
        return color;
    }

    @JsonSetter
    public void setColor(String color) {
        this.color = color;
    }

    @JsonGetter
    public String getType() {
        return type;
    }

    @JsonSetter
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");

        //序列化过程
//        String s = mapper.writeValueAsString(car);  返回json字符串
//        System.out.println(s);
        mapper.writeValue(new File("car.json"),car); //返回.json文件

        //反序列化过程

        //1.将json字符串反序列成java对象
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car1 = mapper.readValue(json, Car.class);
        System.out.println(car1);

        //2.读取json文件将json字符串反序列成java对象
        Car car2 = mapper.readValue(new File("car.json"), Car.class);
        System.out.println(car2);

        Car car3 = mapper.readValue(new URL("file:car.json"), Car.class);
        System.out.println(car3);

        System.out.println();
        System.out.println("***********JSON to Jackson JsonNode*************");
        String json1 = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = mapper.readTree(json1);
        String color = jsonNode.get("color").asText();
        System.out.println(color);

        System.out.println();
        System.out.println("******************从JSON数组字符串创建Java列表*****************");
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = mapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
        System.out.println(listCar);

        System.out.println();
        System.out.println("**********将json转换为java的map********");
        String json2 = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map
                = mapper.readValue(json2, new TypeReference<Map<String,Object>>(){});
        System.out.println(map);

        System.out.println();
        System.out.println("********************");
        String jsonString
                = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
//        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car c = mapper.readValue(jsonString, Car.class);

        JsonNode jsonNodeRoot = mapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();
        System.out.println(year);

    }

}

package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
//We can ignore specific fields at the class level, using the @JsonIgnoreProperties annotation and specifying the fields by name:
//@JsonIgnoreProperties(value = {"intValue","stringValue"})

//Ignore Null Fields on the Class
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stringValue;

    //We can also ignore a field directly via the @JsonIgnore annotation directly on the field:
    @JsonIgnore
    private int intValue;

    @JsonIgnore
    private boolean booleanValue;

    public MyDto() {
        super();
    }

    // standard setters and getters are not shown

    @JsonProperty("strVal")  //Change Name of Field for Serialization
    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return "MyDto{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", booleanValue=" + booleanValue +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        MyDto myDto = new MyDto();
        myDto.setStringValue("zs");
        myDto.setIntValue(1);
        myDto.setBooleanValue(false);

        ObjectMapper mapper = new ObjectMapper();
        //Ignore Null Fields Globally
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String s = mapper.writeValueAsString(myDto);
        System.out.println(s);
    }

}

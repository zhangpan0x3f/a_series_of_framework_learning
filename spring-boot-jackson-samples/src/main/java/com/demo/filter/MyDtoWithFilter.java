package com.demo.filter;

import com.demo.entity.MyDto;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author zhang pan
 * @Description 类描述
 */
@JsonFilter("myFilter")
public class MyDtoWithFilter {

    public static void main(String[] args) throws JsonProcessingException {
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("intValue");
        FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
        ObjectMapper mapper = new ObjectMapper();
        MyDto myDto = new MyDto();
        myDto.setStringValue("sda");
        myDto.setIntValue(1);
        myDto.setBooleanValue(false);
        String dtoAsString = mapper.writer(filters).writeValueAsString(myDto);
        System.out.println(dtoAsString);
    }

}

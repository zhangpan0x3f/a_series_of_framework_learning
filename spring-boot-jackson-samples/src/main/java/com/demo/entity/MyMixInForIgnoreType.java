package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhang pan
 * @Description 类描述
 */
@JsonIgnoreType
public class MyMixInForIgnoreType {

    public static void main(String[] args) throws JsonProcessingException {
        MixInItem item = new MixInItem(1, "book", null);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(User.class, MyMixInForIgnoreType.class);

        result = mapper.writeValueAsString(item);
        System.out.println(result);
    }

}

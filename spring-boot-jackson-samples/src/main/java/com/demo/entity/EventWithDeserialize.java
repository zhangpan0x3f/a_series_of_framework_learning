package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class EventWithDeserialize {

    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

    @JsonCreator
    public EventWithDeserialize(@JsonProperty("name") String name,@JsonProperty("eventDate") Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

//    public static void main(String[] args) throws JsonProcessingException {
//        String json
//                = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
//
//        SimpleDateFormat df
//                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//        EventWithSerializer event = new ObjectMapper()
//                .readerFor(EventWithSerializer.class)
//                .readValue(json);
//        System.out.println(event);
//    }

}

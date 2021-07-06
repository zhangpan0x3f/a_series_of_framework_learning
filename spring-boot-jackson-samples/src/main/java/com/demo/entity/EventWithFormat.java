package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class EventWithFormat {

    private String name;

    /***
     * @JsonFormat 指定序列化日期/时间值时的格式。
     */
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss"
    )
    private Date eventDate;

    public EventWithFormat(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "27-3-2021 14:54:00";
        Date date = df.parse(toParse);
        EventWithFormat event = new EventWithFormat("party", date);

        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }

}

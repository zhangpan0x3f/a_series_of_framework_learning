package com.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class Book {

    String title;

    Optional<String> subTitle;

    // getters and setters omitted

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Optional<String> getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(Optional<String> subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", subTitle=" + subTitle +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
//        //序列化
//        Book book = new Book();
//        book.setTitle("Oliver Twist");
//        book.setSubTitle(Optional.of("The Parish Boy's Progress"));
//        System.out.println(book);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new Jdk8Module());
//        String result = mapper.writeValueAsString(book);
//        System.out.println(result);
//
//        //反序列化
//        Book newBook = mapper.readValue(result, Book.class);
//        System.out.println(newBook);

        //Map集合的序列化
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        System.out.println(jsonResult);
    }

}
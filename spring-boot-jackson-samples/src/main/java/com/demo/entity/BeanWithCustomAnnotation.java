package com.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * @author zhang pan
 * @Description 类描述
 */
@CustomAnnotation
public class BeanWithCustomAnnotation {

    public int id;

    public String name;

    public Date dateCreated;

    public BeanWithCustomAnnotation(int id, String name, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public static void main(String[] args) throws JsonProcessingException {
        BeanWithCustomAnnotation bean
                = new BeanWithCustomAnnotation(1, "My bean", null);

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

}

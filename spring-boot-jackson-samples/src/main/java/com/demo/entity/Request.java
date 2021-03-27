package com.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class Request
{
    private Car car;
    private Date datePurchased;

    // standard getters setters

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    @Override
    public String toString() {
        return "Request{" +
                "car=" + car +
                ", datePurchased=" + datePurchased +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        Request request = new Request();
        request.setCar(new Car("red","BWM"));
        request.setDatePurchased(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);
        String carAsString = objectMapper.writeValueAsString(request);
        System.out.println(carAsString);
// output: {"car":{"color":"yellow","type":"renault"},"datePurchased":"2016-07-03 11:43 AM CEST"}

        System.out.println();
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        ObjectMapper mapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        Car[] cars = objectMapper.readValue(jsonCarArray, Car[].class);
        System.out.println(cars);

        System.out.println();
        String jsonCarArray1 =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        ObjectMapper mapper1 = new ObjectMapper();
        List<Car> listCar = objectMapper.readValue(jsonCarArray1, new TypeReference<List<Car>>(){});
        System.out.println(listCar);
// print cars
    }

}
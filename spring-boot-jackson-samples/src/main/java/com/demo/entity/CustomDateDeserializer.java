package com.demo.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class CustomDateDeserializer
        extends StdDeserializer<Date> {

    private static SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        String data = "20-12-2014 02:30:00";
        try {
            return formatter.parse(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

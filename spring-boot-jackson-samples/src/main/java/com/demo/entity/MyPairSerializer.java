package com.demo.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class MyPairSerializer extends JsonSerializer<MyPair> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(MyPair value,
                          JsonGenerator gen,
                          SerializerProvider serializers)
            throws IOException, JsonProcessingException {

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, value);
        gen.writeFieldName(writer.toString());
    }

    public static void main(String[] args) throws JsonProcessingException {
        String jsonInput = "{\"key\": \"value\",\"key1\": \"value1\"}";
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> typeRef
                = new TypeReference<HashMap<String, String>>() {};
        Map<String, String> map = mapper.readValue(jsonInput, typeRef);
        System.out.println(map);
    }

}

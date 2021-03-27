package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class ExtendableBean {

    private String name;

    private Map<String,String> getProperties;

    /**
     * The @JsonAnyGetter annotation allows for the flexibility of using a Map field
     * as standard properties.
     * @return
     */
    @JsonAnyGetter
    public Map<String, String> getGetProperties() {
        return getProperties;
    }

}

package com.demo;


import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * @author : zhang pan
 * @date : 11:51 上午 2021/5/19
 * 描述：
 */
public class ValExample {

    public String example(){
        val example = new ArrayList<String>();
        example.add("Hello, World!");
        val foo = example.get(0);
        return foo.toLowerCase();
    }

    public void example2(){
        val map = new HashMap<Integer,String>();
        map.put(0,"zero");
        map.put(5,"five");
        for(val entry : map.entrySet()){
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }
    }

}

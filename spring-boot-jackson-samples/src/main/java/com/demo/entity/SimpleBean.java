package com.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

/**
 * @author zhang pan
 * @Description 类描述
 */
public class SimpleBean {

    private int x = 1;
    private int y = 2;

    //standard setters and getters


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String

    toString() {
        return "SimpleBean{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        //序列化的方式

        //1.序列化成json字符串
//        SimpleBean simpleBean = new SimpleBean();
//        simpleBean.setX(10);
//        simpleBean.setY(10);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        String s = xmlMapper.writeValueAsString(simpleBean);
//        System.out.println(s);

        //2.序列化成xml文件
//        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.writeValue(new File("simple_bean.xml"), new SimpleBean());
//        File file = new File("simple_bean.xml");

        //反序列化

        //1.从xml字符串进行序列化
//        XmlMapper xmlMapper = new XmlMapper();
//        SimpleBean value
//                = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
//        System.out.println(value);

        //2.从xml文件进行序列化
//        File file = new File("simple_bean.xml");
//        XmlMapper xmlMapper = new XmlMapper();
//        String xml = inputStreamToString(new FileInputStream(file));
//        SimpleBean value = xmlMapper.readValue(xml, SimpleBean.class);
//        System.out.println(value);


        //将json字符串转化为JsonNode
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(jsonString);
        System.out.println(actualObj);

        //当一个json字符串转换位jsonNode之后，我们可以使用json树模型
        JsonNode k1 = actualObj.get("k1");
        System.out.println(k1);
    }

}

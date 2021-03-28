package com.demo.entity;

/**
 * @author zhang pan
 * @Description blog实体类
 */
public class Blog {

    private Integer id;

    private String blog;

    public Blog() {
    }

    public Blog(Integer id, String blog) {
        this.id = id;
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", blog='" + blog + '\'' +
                '}';
    }
}

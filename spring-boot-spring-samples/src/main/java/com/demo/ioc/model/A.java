package com.demo.ioc.model;

/**
 * @author : zhang pan
 * @date : 4:13 下午 2021/7/13
 * 描述：
 */
public class A {

    private B b;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}

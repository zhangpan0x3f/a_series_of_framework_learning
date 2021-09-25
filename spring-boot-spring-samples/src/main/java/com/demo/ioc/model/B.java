package com.demo.ioc.model;

/**
 * @author : zhang pan
 * @date : 4:13 下午 2021/7/13
 * 描述：
 */
public class B {

    private A a;

    public B() {
    }

    public B(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}

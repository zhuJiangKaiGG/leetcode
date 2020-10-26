package com.test.demo.test.troublesolution;

import java.util.Random;

/**
 * @Author :zjk
 * @Date :Create in 10:13 2020-10-26
 * @Description
 **/
public class StaticDispatch {
    static class Human{}
    static class Man extends Human{}
    static class Women extends Human{}

    public void sayHello(Human human) {
        System.out.println("hello human");
    }

    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Women women) {
        System.out.println("hello women");
    }

    public static void main(String[] args) {
        Human human = (new Random()).nextBoolean() ? new Man() : new Women();
//        Human man = new Man();
//        Human women = new Women();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello((Man)human);
        staticDispatch.sayHello((Women)human);
    }
}

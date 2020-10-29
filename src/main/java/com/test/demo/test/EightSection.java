package com.test.demo.test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.List;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @Author :zjk
 * @Date :Create in 10:53 2020-10-27
 * @Description jvm第八章实战
 **/
public class EightSection {


    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 300;
        Integer f = 200;
        Integer h = 500;
        Long g = 3L;
        System.out.println(h == (e + f));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

}

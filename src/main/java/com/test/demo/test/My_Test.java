package com.test.demo.test;

/**
 * @Author :zjk
 * @Date :Create in 10:11 2020-10-30
 * @Description
 **/
public class My_Test {
    public static int exceptionOne(){
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("除数不能为0");
        }
        return 1;
    }
    public static void getReturn(){
        int i = exceptionOne();
        System.out.println(i);
    }
    public static void main(String[] args) {
        getReturn();
    }
}

package com.test.demo.test;

/**
 * @Author :zjk
 * @Date :Create in 10:56 2020-09-29
 * @Description 单例模式测试
 **/
public class SingletonTest {
    private static class SingletonHolder{
        private static final SingletonTest INSTANCE = new SingletonTest();
    }
    private SingletonTest(){}

    public static final SingletonTest getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

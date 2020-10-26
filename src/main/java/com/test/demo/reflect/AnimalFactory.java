package com.test.demo.reflect;

/**
 * @Author :zjk
 * @Date :Create in 14:23 2020-10-05
 * @Description 动物工厂
 **/
public class AnimalFactory {
    public static Animal createAnimal(String name) throws ClassNotFoundException {
        Class animal = Class.forName(name);
        try {
            Animal o = (Animal) animal.newInstance();
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
}

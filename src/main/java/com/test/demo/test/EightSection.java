package com.test.demo.test;

/**
 * @Author :zjk
 * @Date :Create in 10:53 2020-10-27
 * @Description jvm第八章实战
 **/
public class EightSection {
    class GrandFather {
        void thinking(){
            System.out.println("i am grandfather");
        }
    }
    class Father extends GrandFather{
        void thinking() {
            System.out.println("i am father");
        }
    }
    class Son extends Father{
        void thinking(){
         //   System.out.println("i am son");
//            GrandFather grandFather = new GrandFather();
//            grandFather.thinking();
            try {
                Class grandFather = Class.forName("com.test.demo.test.EightSection$GrandFather");
                try {
                    GrandFather g =(GrandFather) grandFather.newInstance();
                    g.thinking();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new EightSection().new Son().thinking();
    }
}

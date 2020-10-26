package com.test.demo.test.troublesolution;

/**
 * @Author :zjk
 * @Date :Create in 10:38 2020-10-16
 * @Description JHSDB测试
 **/
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj=new ObjectHolder();
        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }
    private static class ObjectHolder {}
    public static void main(String[] args){
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}

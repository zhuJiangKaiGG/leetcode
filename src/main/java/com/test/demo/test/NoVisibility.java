package com.test.demo.test;

/**
 * @Author :zjk
 * @Date :Create in 19:29 2020-09-29
 * @Description
 **/
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;

    }
}

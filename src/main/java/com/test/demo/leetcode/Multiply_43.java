package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:06 2020-11-01
 * @Description 给定两个字符串形式的非负整数，求他们的积，返回的积也为字符串形式
 **/
public class Multiply_43 {
    public  String multiply(String num1, String num2) {
        List<StringBuilder> list = new ArrayList<>();

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int count = 0;
        for (int i = num1.length()-1; i >=0 ; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < count; k++) {
                stringBuilder.append(0);
            }
            int num =Integer.valueOf(String.valueOf(num1.charAt(i))) ;
            int jinWei = 0;
            for (int j = num2.length()-1; j >=0 ; j--) {
                int temp =Integer.valueOf(String.valueOf(num2.charAt(j))) ;
                if (j == 0) {
                    StringBuilder str = new StringBuilder().append(num * temp + jinWei);
                    stringBuilder.append(str.reverse());
                    list.add(stringBuilder);
                    break;
                }
                int a = num * temp + jinWei;
                jinWei = a / 10;
                int yuShu = a % 10;
                stringBuilder.append(yuShu);
                System.out.println("s");
            }
            count++;
        }
        if (list.size() == 1) {
            return list.get(0).reverse().toString();
        }
        String string = list.get(0).reverse().toString();
        for (int i = 1; i <list.size() ; i++) {
            String next = list.get(i).reverse().toString();
            string = twoSum(string, next);
        }
        return string;
    }
    private  String twoSum(String str1,String str2) {
        int i = str1.length()-1, j = str2.length()-1;
        int jinWei = 0;
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(jinWei);
        while ( i>= 0 ||  j>= 0) {
            int num1 = i <0 ? 0 : Integer.valueOf(String.valueOf(str1.charAt(i)));

            int num2 = j < 0 ? 0 : Integer.valueOf(String.valueOf(str2.charAt(j)));
            int sum = num1 + num2 + jinWei;
            jinWei = sum / 10;
            int yuShu = sum % 10;
            stringBuilder.append(yuShu);
            i--;
            j--;
        }
        if (jinWei > 0) {
            stringBuilder.append(jinWei);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
//        String s = twoSum("999", "99");
//        System.out.println(s);
        String s = "111";
        int i = s.charAt(0)-'0';
        System.out.println(i);

    }
}

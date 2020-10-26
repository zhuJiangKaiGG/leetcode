package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 15:09 2020-10-18
 * @Description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 **/
public class Divide_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        boolean sign = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = false;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        int ans = helper(a, b);
        return ans = sign == true ? ans : -ans;
    }

    private int helper(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int temp_b = b;
        while (temp_b + temp_b < 0 && a <= temp_b + temp_b) {
            temp_b += temp_b;
            count += count;
        }
        return count + helper(a - temp_b, b);
    }
    /**
     public int divide(int dividend, int divisor) {
     if (dividend == Integer.MIN_VALUE && divisor == -1) {
     return Integer.MAX_VALUE;
     }

     // 判断结果是不是负数
     boolean isNegative = (dividend ^ divisor) < 0 ? true : false;

     // 将除数和被除数都转为负数
     dividend = dividend < 0 ? dividend : -dividend;
     divisor = divisor < 0 ? divisor : -divisor;

     int res = helper(dividend, divisor);

     return isNegative ? -res : res;
     }

     private int helper(int dividend, int divisor) {
     if (dividend > divisor) {
     return 0;
     }

     int tmp = divisor;
     int count = 1;

     // 条件tmp + tmp < 0防止溢出
     while (tmp + tmp < 0 && dividend <= tmp + tmp) {
     count += count;
     tmp += tmp;
     }

     return count + helper(dividend - tmp, divisor);
     }
     * @param args
     */

}

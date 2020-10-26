package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 16:07 2020-10-04
 * @Description 整数反转
 **/
public class IntegerReserve_7 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        String result = "";
        int re=0;
        char[] chars = s.toCharArray();
        if (chars[0] == '+' || chars[0] == '-') {
            result = result + chars[0];
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isDigit(chars[i]))
                result = result + chars[i];
        }
        Long aLong = Long.valueOf(result);
        if (chars[0] == '-') {
            long max = Math.max(aLong, (long) Integer.MIN_VALUE);
            if (max == aLong) {
                re = Integer.valueOf(result);
            }
        } else {
            long min = Math.min(aLong, (long) Integer.MAX_VALUE);
            if (min == aLong) {
                re = Integer.valueOf(result);
            }
        }
        return re;
    }
}

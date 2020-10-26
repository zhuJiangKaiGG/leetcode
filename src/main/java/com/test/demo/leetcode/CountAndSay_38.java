package com.test.demo.leetcode;

import java.util.HashMap;

/**
 * @Author :zjk
 * @Date :Create in 16:42 2020-10-26
 * @Description 给定一个整数n（最大值为30），输出外观数列的第n项
 **/
public class CountAndSay_38 {
    public String countAndSay(int n) {
        String str = "";
        for (int i = 1; i <= n; i++) {
            int count = 1;
            char pre = str.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 1) {
                str = "1";
            } else {
                for (int k = 1; k < str.length(); k++) {
                    char c = str.charAt(k);
                    if (c == pre) {
                        count++;
                    } else {
                        stringBuilder.append(count).append(pre);
                        pre = c;
                        count = 1;
                    }
                }
                stringBuilder.append(count).append(pre);
                str = stringBuilder.toString();
            }
        }
        return str;
    }

}

package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 15:17 2020-10-07
 * @Description 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IntToRoman_12 {
    public String intToRoman(int num) {
        String[] strs = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        int a, b, i = 0;
        StringBuffer ans = new StringBuffer("");
        while (true) {
            a = num % 10;
            num = num / 10;
            if (a == 9) {
                ans = ans.append(strs[i+2]).append(strs[i]);
            } else if (a == 4) {
                ans = ans.append(strs[i+1]).append(strs[i]);
            } else {
                if (a >= 5) {

                    for (int j = 0; j < a - 5; j++) {
                        ans = ans.append(strs[i]);
                    }
                    ans = ans.append(strs[i + 1]);
                } else {
                    for (int k = 0; k < a; k++) {
                        ans = ans.append(strs[i]);
                    }
                }
            }

            if (num == 0) {
                break;
            }
            i = i + 2;
        }
        return ans.reverse().toString();
    }
}

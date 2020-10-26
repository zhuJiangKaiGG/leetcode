package com.test.demo.leetcode;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author :zjk
 * @Date :Create in 14:04 2020-10-08
 * @Description 罗马数字转换成整数
 **/
public class RomanToInt_13 {
    public int romanToInt(String s) {
        int ans = 0,pre=0;
        char substring;
        for (int i = 0; i < s.length(); i++) {
            substring = s.charAt(i);
            int mid = getValue(substring);
            if (pre < mid) {
                ans = (ans - pre) + (mid - pre);
                pre = mid;
            } else {
                ans = ans + mid;
                pre = mid;
            }

        }
        return ans;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

//    作者：donespeak
//    链接：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

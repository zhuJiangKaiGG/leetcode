package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:12 2020-10-18
 * @Description 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-strstr 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        if ((haystack.isEmpty()&&!needle.isEmpty()) || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.isEmpty()&&needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            int temp = i;
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(temp) == needle.charAt(j)) {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                    temp++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}

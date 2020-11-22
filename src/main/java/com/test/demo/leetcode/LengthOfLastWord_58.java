package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:05 2020-11-17
 * @Description 给出一个由大小写和空格组成的字符串，计算最后一个单词的长度
 * 从后往前查找，最后一个单词的开始条件是第一个字符不为空，结束条件是当前字符为空，上一个字符不为空
 **/
public class LengthOfLastWord_58 {
    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int count = 0;
        for (int i = n-1; i > 0; i--) {
            //退出遍历，要注意i != n-1,否则会溢出
            if (i != n - 1 && s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                break;
            }
            if (s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}

package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:07 2020-10-14
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 **/
public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        generateAll(ans,new char[2*n],0);
        return ans;
    }
    private void generateAll(List<String>result,char[]chars,int pos){
        System.out.println("又一次");
        if (pos == chars.length) {
            System.out.println("等长");
            if (valid(chars)) {
                result.add(chars.toString());
            }
        } else {
            chars[pos] = '(';
            generateAll(result, chars, pos + 1);
            chars[pos] = ')';
            System.out.println("second");
            generateAll(result, chars, pos + 1);
        }
    }
    private boolean valid(char[]chars){
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}

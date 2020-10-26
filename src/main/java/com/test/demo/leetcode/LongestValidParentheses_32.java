package com.test.demo.leetcode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:14 2020-10-21
 * @Description 给定一个只有“(”和“)”组成的字符串，找出包括最长有效括号的字串长度
 * 例如((()()(  最长为4（）（）
 * 例如"(()"
 * 例如 ")()())"
 * "()(()"
 **/
public class LongestValidParentheses_32 {
    //    public int longestValidParentheses(String s) {
//        if (s.length() <= 1) {
//            return 0;
//        }
//        int count = 0,ans=0;
//        List<Character> leftParentheses = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                leftParentheses.add(s.charAt(i));
//            } else {
//                if (CollectionUtils.isEmpty(leftParentheses)) {
//                    ans = count * 2 > ans ? count * 2 : ans;
//                    count = 0;
//                } else {
//                    leftParentheses.remove(leftParentheses.size() - 1);
//                    count++;
//                    ans = count * 2 > ans ? count * 2 : ans;
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 用栈的思想来解决问题，找出最长字串的长度可以用下标来计算
     * Deque定义一个栈，栈底保存的是第一个没有匹配到的右括号，所以创建栈之后压入-1到栈中，表示第一个没有匹配到的右括号
     * 遇到“(”时将其加入到栈中，遇到“)”时，弹出栈顶元素。
     * 此时当栈为空时，将“)”的下标入栈
     * 不为空时将“)”的下标减去栈顶元素，可得到此右括号所包含有效括号的最长子串长度
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxL=0;
        Deque<Integer> stack = new LinkedList();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxL = Math.max(maxL, i - stack.peek());
                }
            }
        }
        return maxL;
    }
}

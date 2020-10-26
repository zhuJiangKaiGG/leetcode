package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:10 2020-10-19
 * @Description 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 **/
public class FindSubstring_30 {
    /**
     * 用两个hashMap来处理字符串匹配
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String,Integer>allWords = new HashMap();

        int wordNums = words.length;
        if (wordNums == 0) {
            return ans;
        }
        //当数组中全部都是空串时，返回s的所有下标
        if (words[0].isEmpty()) {
            for (int i = 0; i < s.length(); i++) {
                ans.add(i);
            }
            return ans;
        }
        int wordLength = words[0].length();
        //给allWords中存入值
        for (int i = 0; i < words.length; i++) {
            int count = allWords.getOrDefault(words[i], 0);
            allWords.put(words[i], count + 1);
        }
        for (int i = 0; i <s.length()-wordNums*wordLength+1 ; i++) {
            //用于记录比较的单词个数
            int num = 0;
            HashMap<String,Integer> hasWords = new HashMap();
            while (num < wordNums) {
                //i要用来做位移
                String substring = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                if (allWords.containsKey(substring)) {
                    int hasCount = hasWords.getOrDefault(substring, 0);
                    //不能用count++,会先将值存入，再++
                    hasWords.put(substring, hasCount+1);
                    if (hasWords.get(substring) > allWords.get(substring)) {
                        break;
                    }
                    //不匹配则退出此次匹配
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNums) {
                ans.add(i);
            }
        }
        return ans;
    }
}

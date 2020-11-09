package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:51 2020-11-05
 * @Description 给定一个字符串数组，将数组中的字母异位词组合在一起，字母异位词指的是字符串的字母构成相同，但字母的位置不同。
 *  将字符串重排序，再使用hapMap来确定是否是字母异位符
 **/
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String,List> hashMap = new HashMap<>();
        for (String s : strs) {
           char[] chars = s.toCharArray();
           // 排序
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (!hashMap.containsKey(temp)) {
                hashMap.put(temp, new ArrayList<>());
            }
            hashMap.get(temp).add(s);
        }
        // ArrayList后面没有尖括号
        List<List<String>>ans=new ArrayList(hashMap.values());
        return ans;
    }


}

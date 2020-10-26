package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:56 2020-10-08
 * @Description 最长公共前缀
 **/
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int left = 0, right = strs.length - 1;
        int index = 0;
        while (left < right) {
            if (strs[left].equals("")||strs[right].equals("")) {
                return "";
            }
            int length = strs[left].length() >= strs[right].length() ? strs[right].length() : strs[left].length();
            for (int i = 0; i <= length; i++) {
                if(i==length){
                    if(left==0){
                        index=i;
                    }
                    else{
                        index = Math.min(index,i);
                    }
                    left++;

                    break;
                }
                if (strs[left].charAt(i) == strs[right].charAt(i)) {

                } else {

                    if(left==0){
                        index=i;
                    }
                    else{
                        //主要是选择index的值，第一次直接是i的值
                       index = Math.min(index,i);
                    }
                    left++;
                    break;
                }
            }
        }
        return strs[0].substring(0,index);
    }


}

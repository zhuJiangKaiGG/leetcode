package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:16 2020-10-07
 * @Description 盛最多水的容器
 **/
public class MaxArea_11 {
    public int maxArea(int[] height) {
        if(height.length==2){
            return Math.min(height[0], height[1]);
        }
        int capacity = 0;
        int length;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                length = Math.min(height[i], height[j]);
                capacity = Math.max(capacity,length*(j-i));
            }
        }
        return capacity;
    }
}

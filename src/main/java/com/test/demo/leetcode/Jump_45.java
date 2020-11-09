package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:06 2020-11-03
 * @Description 给定一个非负整数数组，假定你处在数组的第一个位置，数组的每一个值表示你可以跳的最大长度，求跳到数组最后一个数锁需要的最少步数
 * 贪心算法，选择一个从当前位置能跳跃到数组尾部的位置，可能存在多个这样的下标，所以选择离数组尾部最远的那一个，再把选定了的数组下标作为尾部，依次类推
 **/
public class Jump_45 {
    public static int jump (int nums[]) {
        int position = nums.length - 1, step = 0;
        while (position > 0) {
            for (int i = 0; i < position ; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                }
            }
        }
        return step;
    }
}

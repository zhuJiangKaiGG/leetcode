package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 13:25 2020-11-12
 * @Description 给定一个非负数组，数组的下标表示当前的位置，数组的值表示当前可以跳跃的最大长度，从下标为0开始，判断能否跳到数组尾部
 * 贪心算法，与45题相同
 * 从前往后找到第一个能跳到数组尾部的下标，如果能找到则将position的值赋值为当前的i下标，重新开始寻找能到达position的下标i
 **/
public class CanJump_55 {
    public static boolean canJump(int[] nums) {
        int i = 0;
        int position = nums.length - 1;
        while (position > 0) {
            if (i == position) {
                break;
            }
            if (nums[i] + i >= position) {
                position = i;
                i = -1;
            }
            i++;
        }
        return position == 0 ? true : false;
    }
}

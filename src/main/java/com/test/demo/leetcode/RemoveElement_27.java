package com.test.demo.leetcode;

import java.util.Arrays;

/**
 * @Author :zjk
 * @Date :Create in 15:23 2020-10-16
 * @Description 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-element 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        Arrays.sort(nums);
        if (val > nums[nums.length - 1]) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                int temp=nums[length-1];
                nums[length - 1] = nums[i];
                nums[i] = temp;
                length--;
            }
        }
        return length-1;
    }
}

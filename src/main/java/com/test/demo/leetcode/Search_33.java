package com.test.demo.leetcode;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMUniOp;

/**
 * @Author :zjk
 * @Date :Create in 15:38 2020-10-22
 * @Description 给定一个升序数组和目标值，数组在未知的某个位置进行了旋转，请找出目标值在旋转后数组中出现的下标值，如果数组不存在目标值，则返回-1
 * 数组中的数字不重复
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 **/
public class Search_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {

                return mid;
            }
            //每次都应该与最左边去判断中间值分配在哪个区间
            if (nums[0] < nums[mid]) {
                if (nums[mid]>target&&nums[0]<target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (nums[mid]<target&&nums[nums.length-1]>=target) {
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
        }
        Object object = new Object();
        return -1;
    }
}

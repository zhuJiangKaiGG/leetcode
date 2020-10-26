package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:28 2020-10-23
 * @Description 给定一个无重复值的升序数组和一个目标值，找出目标值在数组中出现的下标值，如果数组中不存在目标值，返回它将会被按顺序插入的下标值
 * 将题目转换成查找第一个大于或等于目标值的数组下标
 **/
//自己的思路是target满足条件nums[i] < target && target <= nums[i + 1],返回i+1
public class SearchInsert_35 {
    public int searchInsert(int nums[],int target){
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && target <= nums[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int nums[], int target) {
//        if (target <= nums[0]) {
//            return 0;
//        }
//        if (target > nums[nums.length - 1]) {
//            return nums.length;
//        }
//        int left = 0,right=nums.length;
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            }
//            if (nums[mid] < target && target <= nums[mid + 1]) {
//                return mid + 1;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            }
//        }
//        return -1;
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid+1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

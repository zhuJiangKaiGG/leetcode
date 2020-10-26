package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:08 2020-10-12
 * @Description 四数之和
 **/
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 3) {
            return lists;
        }
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-3 ; i++) {
            //当遇到相同的值时，不需要进行
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //当前四个数比目标数要大时，即没有与之相等的数，可以退出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //当后三个数与num[i]的和大于target时表明此次循环没有比target大的数，跳出此次循环
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i+1; j <nums.length-2 ; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j+1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                    } else if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while (true) {
                            if (nums[left] == nums[left + 1]&&left+1<right) {
                                left++;
                            } else {
                                left++;
                                break;
                            }
                        }
                    } else {
                        while (true) {
                            if (nums[left] == nums[left + 1]&&left+1<right) {
                                left++;
                            } else {
                                left++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }
}

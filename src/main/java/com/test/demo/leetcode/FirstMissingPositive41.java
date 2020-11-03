package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:09 2020-10-29
 * @Description 给出一个未排序的整数数组，找出数组中第一个未出现的最小正整数
 **/
public class FirstMissingPositive41 {
    public static int firstMissingPositive(int[] nums) {
        int ans = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            } else {
                for (int j = 1; j <=nums[nums.length-1] ; j++) {
                    if (j < nums[i]) {
                        ans = j;
                        return ans;
                    } else {
                        i++;
                        //当遍历完数组还未找到未出现的最小值，说明未出现的最小值为数组最大值加一
                        if (i == nums.length) {
                            ans = nums[nums.length-1] + 1;
                            return ans;
                        }
                        //如果两个数相等则j不变
                        if (nums[i] == nums[i - 1]) {
                            j--;
                        }
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 将nums[i]这个值放到数组下标为nums[i]-1的位置，这样数组下标与数组值就存在了一种关系，即i+1=nums[i]
     * 因此现在考虑的是哪些值需要交换，由于值要与数组下标建立关联，所以要交换的值不能大于数组的长度
     * 当当前遍历的数值与需要交换的那个位置的数组相等时，不需要交换
     * 交换的值应该大于0
     * 交换后num[i]的值可以需要继续交换位置，因此要i--
     * 当数组中的值全部交换完成后，再遍历数组。如果数组的下标与数组的值不满足i+1=nums[i],则返回i+1
     * @param nums
     * @return
     */
    public static int answerMethod(int nums[]){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            int x = nums[i];
            if (x >= 1 && x < nums.length && x != nums[x-1]) {
                int temp=nums[x-1];
                nums[x-1]=x;
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9});
    }
}

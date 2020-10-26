package com.test.demo.leetcode;

import java.util.Arrays;

/**
 * @Author :zjk
 * @Date :Create in 14:20 2020-10-20
 * @Description 给定一个数字序列，将这个序列重新排序，找出比给定数列更大的下一个数列,如果没有更大的数，则输出最小的数
 * 例如123，输出132，321，输出123
 **/
public class NextPermutation_31 {
    //    public void nextPermutation(int[] nums) {
//        boolean isMax = true;
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i] < nums[i + 1]) {
//                isMax = false;
//            }
//        }
//        if (isMax) {
//            System.out.println("sdsds");
//            Arrays.sort(nums);
//            return;
//        }
//        if (nums.length <= 1) {
//            return;
//        }
//        for (int i = nums.length - 1; i > 0; i--) {
//            for (int j = i-1; j >= 0; j--) {
//                if (nums[i] > nums[j]) {
//                    System.out.println(nums[j]);
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    //paixu
//                        for (int k = j+1; k <nums.length-1 ; k++) {
//                            for (int l = k+1; l <nums.length ; l++) {
//                                if (nums[k] > nums[l]) {
//                                    int temp1 = nums[k];
//                                    nums[k] = nums[l];
//                                    nums[l] = temp1;
//                                }
//                            }
//                        }
//                    return;
//                }
//            }
//        }
//    }
    public void nextPermutation(int nums[]) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {

                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int length = nums.length - 1;
        i = i + 1;
        while (i < length) {
            int temp1 = nums[i];
            nums[i] = nums[length];
            nums[length] = temp1;
            i++;
            length--;
        }
    }
}

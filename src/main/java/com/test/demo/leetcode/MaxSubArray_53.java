package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:40 2020-11-10
 * @Description 给定一个整数数组，找出其连续的子数组的和的最大值，返回此最大值
 * 最基础的思路是进行两次嵌套循环遍历，每次相加更新最大值，但是此时需要注意会出现值溢出的情况，例如两个数都是MIN_VALUE,则相加会溢出。由于返回的值为int类型，
 * 所以不用考虑和溢出的情况。
 * 对于负数溢出的情况，我们可以不对负数进行相加，因为负数相加更小。
 * 我们从前往后进行遍历，当遍历到负数时，我们只需要判断这个负数是不是比已经保存的max要大，大就替换max的值。
 * 当遍历到第一个正数（i）时，再对此数后面的数进行遍历，并相加。
 * 当sum为负数时，停止遍历，此时以i开头的连续子数组的最大值已经判断完成
 * 这时我们可以从i+1来遍历数组，不过我们可以直接从i = j + 1来遍历数组，因为我们舍弃了nums[i]这个正数，则在i~j这个连续的子数组和会更小，所以可以不考虑此部分
 * 因此时间复杂度为n,只需要遍历一遍数组即可
 **/
public class MaxSubArray_53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                max = Math.max(max, nums[i]);
                continue;
            } else {
                max = Math.max(max, nums[i]);
                int sum = nums[i];
                for (int j = i+1; j < n; j++) {
                    sum = sum + nums[j];
                    max = Math.max(max, sum);
                    if (sum < 0) {
                        i = j;
                        break;
                    }
                }
            }
        }
        return max;
    }
}

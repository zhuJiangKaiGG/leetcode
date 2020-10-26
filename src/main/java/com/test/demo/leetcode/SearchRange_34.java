package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:15 2020-10-22
 * @Description 给定一个升序数组，和一个目标值，找出数组中目标值出现的第一个位置和最后位置的下标，如果数组中不存在目标值，返回[-1,-1]
 * 时间复杂度控制在logN
 **/
public class SearchRange_34 {
    /**
     * 时间复杂度n
     * @param nums
     * @param target
     * @return
     */
//    public int[] searchRange(int[] nums,int target) {
//        int left = 0, right = nums.length - 1;
//        int[] ans = new int[]{-1, -1};
//        boolean theFirst = false;
//        boolean theLast = false;
//        while (left <= right) {
//            if (nums[left] == target&&!theFirst) {
//                theFirst = true;
//                ans[0] = left;
//            }
//            if (nums[right] == target&&!theLast) {
//                theLast = true;
//                ans[1] = right;
//            }
//            if (!theFirst) {
//                left++;
//            }
//            if (!theLast) {
//                right--;
//            }
//            if (theFirst && theLast) {
//                break;
//            }
//        }
//        return ans;
//    }
    public int extremeInsertionIndex(int nums[],boolean left,int target) {
        int leftIndex = 0, rightIndex = nums.length;
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] > target || left && nums[mid] == target) {
                rightIndex = mid;
            } else {
                leftIndex = mid + 1;
            }
        }
        return leftIndex;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftIndex = extremeInsertionIndex(nums, true, target);
        if (leftIndex == nums.length || nums[leftIndex] != target) {//数组中不存在目标值，第一个判断条件是当target值大于数组的最大值时，为了防止nums[leftIndex]越界而设置的
            return ans;
        }
        int rightIndex = extremeInsertionIndex(nums, false, target);
        ans[0] = leftIndex;
        ans[1] = rightIndex - 1;
        return ans;
    }
}


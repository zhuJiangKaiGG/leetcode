package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 9:54 2020-10-17
 * @Description 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Search_1003 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (right == -1) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (target <= nums[mid] || target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[left] != target) {
                    left++;
                } else {
                    right = left;
                }
            }
        }
        return (nums[left] == target) ? left : -1;
    }
}

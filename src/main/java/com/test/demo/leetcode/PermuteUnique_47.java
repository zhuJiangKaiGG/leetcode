package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 15:11 2020-11-04
 * @Description 给定一个存在重复值的数组，按任意顺序返回不重复的全排列
 **/
public class PermuteUnique_47 {
    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        tree(nums, 0, list, flag);
        return lists;
    }
    private static void tree(int nums[], int index, List<Integer> list, int[] flag) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]==1 || (i > 0 && nums[i] == nums[i - 1] && flag[i - 1]==0)) {
                continue;
            }

                flag[i] = 1;
                list.add(nums[i]);
                tree(nums, index + 1, list, flag);
                list.remove(list.size() - 1);
                flag[i] = 0;

        }
    }
}

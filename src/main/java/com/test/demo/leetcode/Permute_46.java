package com.test.demo.leetcode;

import java.util.List;
import java.util.*;
/**
 * @Author :zjk
 * @Date :Create in 15:32 2020-11-03
 * @Description 给定一个整数数组，返回其所有的排列组合
 * 回溯 递归
 **/
public class Permute_46 {
    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> permute (int[] nums) {
        List<Integer> list = new ArrayList<>();
        // 用来记录第i个数有没有被访问
        int[] flag = new int[nums.length];
        tree(nums, list, 0, flag);
        return lists;
    }

    private static void tree(int[] nums, List<Integer> list, int index, int[] flag) {
        if (list.size() == nums.length) { //终止条件
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {//i的起始值为0，不是index
            if (flag[i] == 0) {//此数没有被访问
                list.add(nums[i]);
                flag[i] = 1;
                tree(nums, list, index + 1, flag);
                list.remove(list.size() - 1);
                flag[i] = 0;
            }
        }
    }
    public static void main (String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3,4});
        System.out.println(permute.size());
    }
}

package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:03 2020-10-28
 * @Description 给定一个数组和目标数，找出数组中所有可以使数字和为target的组合，数组中的元素只能使用一遍，并且不能存在相同的组合数
 * 数组和目标数都是正整数
 **/

/**
 * 此题的解题思路与39题类似，采用回溯加递归相结合的方法，由于数组中会存在相同的值，所以会出现相同的组合结果。因此需要对39题的方法进行一些剪枝操作。
 * 通常对数组的剪枝操作需要先对数组排序
 * 去重的主要思路是：先对数组排序，依次遍历数组的各个元素，在遍历当前第i个元素时，函数会找到以这个元素为头节点的所有组合方式，所以当第i+1个元素与第i个元素
 * 相等时，可以直接跳过此元素（因为包涵此元素的组合已经全部找到了）。因此在循环遍历candidates数组时，要线进行判断是否需要跳过这个元素
 * 判断条件为if(i>index&&candidates[i]==candidates[i-1]) continue;
 * i>index是确保循环已经经过了第一层，确保存在candidates[i-1]
 * 作者：Geralt_U
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii/solution/40-zu-he-zong-he-ii-by-ming-zhi-shan-you-m9rfkvkda/
 * 来源：力扣（LeetCode）
 */
public class CombinationSum_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        search(ans, list, target, 0, candidates);
        return ans;
    }
    private static void search(List<List<Integer>>ans, List<Integer>list,int target,int index,int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(list));

        } else {
            for (int i = index; i <candidates.length ; i++) {
                //如果此次头节点与上次相等，跳过
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                search(ans, list, target - candidates[i], index + 1, candidates);
                list.remove(list.size() - 1);
            }

        }
    }
}


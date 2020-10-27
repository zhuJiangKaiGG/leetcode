package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:04 2020-10-27
 * @Description 给定一个无重复值的数组和一个目标值，找出数组中所有能使和为target的值，数组中的元素可以重复使用
 * 使用回溯的思想
 **/
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(0,ans,list,candidates,target);
        return ans;
    }

    private void search(int index,List<List<Integer>> ans, List<Integer> list, int[] candidates,int target) {
        if (target < 0) {//递归的终止条件
            return;
        }
        if (target == 0) {//当满足条件时，向ans中添加符合条件的答案
            ans.add(new ArrayList<>(list));
            return;
        } else {//不满足条件时，对数组进行遍历，查找满足条件的组合方式
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                //由于可以重复使用数组中的数字，所以递归从当前的下标开始
                search(i, ans, list, candidates, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
    //引用自https://leetcode-cn.com/problems/combination-sum/solution/fei-chang-xiang-xi-de-di-gui-hui-su-tao-lu-by-re-2/
}

package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:26 2020-10-09
 * @Description 三数之和
 **/
public class ThreeSum_15 {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || nums.length < 3) {
            System.out.println("aaaa");
            List<List<Integer>>non_list=new ArrayList<>();
            return non_list;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <nums.length-2 ; i++) {
            for (int j = i+1; j <nums.length-1 ; j++) {
                for (int k = i+2; k <nums.length ; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        ans.add(list);

                    }
                }
            }
        }
        return ans;
    }

}

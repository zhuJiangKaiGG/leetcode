package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:03 2020-11-18
 * @Description 给定两个整数n和k，按组合数的大小列出1~n的组合排列，并返回第k个数
 **/
public class GetPermutation_60 {
    private static String ans = "";
    //private static int count = 0;
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1];
        boolean[] flag = new boolean[n + 1];
        backtrack(n, k, count, list, 1, flag);
        return ans;
    }
    private static void backtrack(int n, int k, int[] count, List<Integer> list, int index, boolean[] flag) {
        if (list.size() == n) {
            count[0]++;
            if (count[0] == k) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Integer integer : list) {
                    stringBuffer.append(integer);
                }
               ans = stringBuffer.toString();
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (flag[i] == false) {
                list.add(i);
                flag[i] = true;
                backtrack(n, k, count, list, index + 1, flag);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        String permutation = getPermutation(3, 1);
        System.out.println(permutation);
    }
}

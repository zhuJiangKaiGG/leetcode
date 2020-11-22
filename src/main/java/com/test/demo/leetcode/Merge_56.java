package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:25 2020-11-12
 * @Description 给出一个区间的集合，合并所有重叠的区间
 * 先将数组按照区间起始点排序，再开始逐个遍历数组。
 * 定义一个列表，用来存储不重叠的数组，当列表为空时或者上一个区间与当前区间不重叠时，将此区间加入到集合中
 * 判断区间重叠的观察上一个数组的右区间是否小于当前数组的左区间，如果小于则不会重叠，不小于则会重叠
 * 发生重叠的情况需要合并两个数组，即右区间选择两个数组中右区间较大的那一个（因为左区间以及是排好序的，所以当前数组的左区间肯定不大于上个数组的左区间，因此不用考虑区间包含的问题）
 **/
public class Merge_56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 重写compare方法，返回正数、零、负数 分别代表大于、等于、小于。
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size()-1)[1] < L) {
                merged.add(intervals[i]);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

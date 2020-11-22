package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:46 2020-11-16
 * @Description 给定一个按照区间左起始点升序排列的二维数组（不存在重叠数组）以及一个待插入的一维数组，
 * 将待插入的数组插入到原始二维数组中，使其仍然满足初始二维数组条件
 *
 * 首先判断待插入的数组与当前数组的位置关系，存在三种关系，
 * 第一待插入的数组在当前数组的左侧，此时将待插入的数组加入到集合当中，并把当前数组加入到集合当中。
 * 第二是待插入的数组在当前数组的右侧，此时可以将当前数组加入到集合当中，但并不能判断是否能将待插入的数组加入到集合中
 * 第三是待插入的数组与当前数组存在交集，此时取两者的并集，进行下次判断。
 * placed用来判断待插入的数组是不是已经插入了。
 **/
public class Insert_57 {
    public static int[][] insert(int[][] intervals, int [] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        List<int[]> asList = new ArrayList<>();
        for (int[] interval : intervals) {
            // 待插入数组在当前数组的左边
            if (interval[0] > right) {
                // placed表示待插入的数组已经插入了
                if (!placed) {
                    asList.add(new int[]{left, right});
                    // 后面的数组都不要判断了
                    placed = true;
                }
                asList.add(interval);
            } else if (interval[1] < left){ //在当前数组的右边
                asList.add(interval);
            } else { //存在交集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        // 如果待插入的数组没有插入，则插入
        if (!placed) {
            asList.add(new int[]{left, right});
        }
        return asList.toArray(new int[asList.size()][]);
    }
}

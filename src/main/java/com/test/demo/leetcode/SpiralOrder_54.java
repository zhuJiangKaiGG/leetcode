package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:02 2020-11-11
 * @Description 给定一个mxn的整数数组，按顺时针旋转返回数组的值
 * 一层一层添加，因此要定义每一层的界限（right，bottom），有一个角来控制每一层的初始位置（left,right）
 **/
public class SpiralOrder_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        // 定义两个角，左上角与右下角
        int left = 0, top = 0, right = columns - 1, bottom = rows - 1;
        // 当两个角重合时或者在同一条线上时为最后一次添加数据
        while (left <= right && top <= bottom) {
            // 从左上到右上
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 从右上到右下
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 判断是否需要从右下到左下以及从左下到左上（当两个角在同一行时不需要进行下面操作）
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left ; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top ; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return list;
    }

}

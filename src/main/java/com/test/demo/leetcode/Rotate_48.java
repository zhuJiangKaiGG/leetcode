package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:08 2020-11-05
 * @Description 给定一个n*n的二维矩阵表示一个图像，将这个图像顺时针旋转90°，输出旋转后的二维矩阵，必须在原地旋转矩阵
 *  先转置矩阵，再交换矩阵的列
 **/
public class Rotate_48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 交换列
        for (int i = 0; i < n; i++) {
            int left = 0, right = n-1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

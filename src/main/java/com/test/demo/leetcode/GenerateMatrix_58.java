package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:28 2020-11-17
 * @Description 给定一个正整数n，生成1到n平方的所有数，并按照顺时针存放在一个二维整数数组中
 * 和螺旋矩阵I的解法类似。对数组一层一层赋值，定义两个对角点，左上（top,left）和右下（bottom,right）。
 * 利用两个点来对数组进行层次赋值。
 * 先定义循环的终止条件：由于给定的矩阵是一个方阵，所以两个对角点最终只会有两种情况，重合或者在二阶方阵的对角
 * 因此终止条件是top <= bottom && left <= right (其实只需要其中一个就行)
 * 再定义循环体中的执行内容：
 * 每一层分为从左到右、从上到下、从右到左以及从下到上四条边，依次对四条变进行赋值。
 * 这里要注意当n为奇数时，最后一层只需要对一条边进行遍历，所以后三条边的遍历需要添加一个条件left < right
 **/
public class GenerateMatrix_58 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int initial = 1;
        int top = 0, left = 0, right = n-1, bottom = n-1;
        while (top <= bottom && left <= right) {
                // 从上左到上右-》
            for (int i = left; i <= right; i++) {

                matrix[top][i] = initial;
                initial++;
            }
            // 如果左上和右下重合则不需要进行下面的操作
            if (left < right) {

                // 从右上到右下|
                for (int i = top + 1; i <= bottom; i++) {
                    matrix[i][right] = initial;
                    initial++;
                }

                // 从下右带到下左《-

                for (int i = right - 1; i >= left; i--) {
                    matrix[bottom][i] = initial;
                    initial++;
                }

                // 从左下到左上

                for (int i = bottom - 1; i > top; i++) {
                    matrix[i][left] = initial;
                    initial++;
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return matrix;
    }
}

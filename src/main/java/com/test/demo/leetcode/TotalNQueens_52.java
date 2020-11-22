package com.test.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author :zjk
 * @Date :Create in 13:59 2020-11-10
 * @Description 给定一个整数N，返回满足N皇后情况的总数
 **/
public class TotalNQueens_52 {
    private static int count = 0;
    public static int totalNQueens(int n) {
        int[] queens = new int[n];

        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(queens, 0, columns, diagonals1, diagonals2, n);
        return count;
    }
    private static void backtrack(int[] queens, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2,int n) {
        if (row == n) {
            count++;
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                if (diagonals1.contains(row - i)) {
                    continue;
                }
                if (diagonals2.contains(row + i)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(row - i);
                diagonals2.add(row + i);
                backtrack(queens, row + 1, columns, diagonals1, diagonals2, n);
                // 是将上一次添加的i移除，而不是集合最上的那一个
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(row - i);
                diagonals2.remove(row + i);
            }
        }
    }
}

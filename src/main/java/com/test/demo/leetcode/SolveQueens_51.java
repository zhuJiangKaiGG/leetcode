package com.test.demo.leetcode;

import java.util.*;

/**
 * @Author :zjk
 * @Date :Create in 14:05 2020-11-09
 * @Description n皇后问题
 *  采用回溯的方法来考虑问题
 *  从第0行开始迭代，判断第row行中queen所在的列位置
 *  迭代的终止条件是达到最后一行之后即row==n，此时表明已经取得了一种合适的放置n皇后的方法。
 *  迭代的具体操作：
 *  迭代时需要判断当前的位置是否适合放置皇后，这里采用Set集合不存在重复值的方法，
 *  对于左斜线，横纵坐标相减的值相同，对于右斜线，横纵坐标相加的值相同
 **/
public class SolveQueens_51 {
    public static List<List<String>> solveQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        List<List<String>> lists = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(lists, queens, 0, n, columns, diagonals1, diagonals2);
        return lists;
    }
    private static void backtrack(List<List<String>> lists, int[] queens, int row, int n, Set<Integer> columns,
                                  Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> list = generateBoard(queens, n);
            lists.add(list);
        }else {
            for (int i = 0; i < n; i++) {
                // 判断当前位置是否合适放置皇后
                if (columns.contains(i)) {
                    continue;
                }
                if (diagonals1.contains(row - i)) {
                    continue;
                }
                if (diagonals2.contains(row + i)) {
                    continue;
                }
                // 此行皇后所在的位置为第i列
                queens[row] = i;
                // 此行以及斜线不能再存放皇后
                columns.add(i);
                diagonals1.add(row - i);
                diagonals2.add(row + i);
                backtrack(lists, queens, row + 1, n, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(row - i);
                diagonals2.remove(row + i);
            }
        }
    }
    private static List<String> generateBoard(int[] queens, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            list.add(new String(chars));
        }
        return list;
    }
//    public static List<List<String>> solveQueens(int n) {
//        String[][] nums = new String[n][n];
//        // 数组初始化
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                nums[i][j] = ".";
//            }
//        }
//
//    }
//
//    /**
//     *
//     * @param i 行坐标
//     * @param j 列坐标
//     * @param nums 棋盘
//     * @return
//     */
//    private static boolean check(int i, int j, String[][] nums) {
//        int n = nums.length;
//        // 对行进行判断
//        for (int col = 0; col < n; col++) {
//            if (nums[i][col].equals("Q")) {
//                return false;
//            }
//        }
//        // 对列进行判断
//        for (int row = 0; row < n; row++) {
//            if (nums[row][j].equals("Q")) {
//                return false;
//            }
//        }
//        //对左上斜线进行判断
//        int row = i-1, col = j-1;
//        while (row >= 0 && col >= 0) {
//            if (nums[row][col].equals("Q")) {
//                return false;
//            }
//            row--;
//            col--;
//        }
//        // 对右上斜线进行判断
//        row = i-1;
//        col = j+1;
//        while (row >= 0 && col < n) {
//            if (nums[row][col].equals("Q")) {
//                return false;
//            }
//            row--;
//            col++;
//        }
//        // 对左下斜线进行判断
//        row = i+1;
//        col = j-1;
//        while (row < n && col >= 0) {
//            if (nums[row][col].equals("Q")) {
//                return false;
//            }
//            row++;
//            col--;
//        }
//        // 对右下斜线进行判断
//        row = i+1;
//        col = j+1;
//        while (row < n && col < n) {
//            if (nums[row][col].equals("Q")) {
//                return false;
//            }
//            row++;
//            col++;
//        }
//        //nums[i][j] = "Q";
//        return true;
//    }
//    private static void tree(String[][] nums, List<String> list, List<List<String>> lists, int length, int row) {
//        if (row == length) {
//            lists.add(list);
//            return;
//        }
//        for (int m = 0; m < nums.length; m++) {
//            for (int n = 0; n < nums.length; n++) {
//                if (check(m,n,nums)) {
//                    nums[m][n] = "Q";
//                    list.add(nums[m][n]);
//                    tree(nums,list,lists,length,row+1);
//                    list.remove(list.size() - 1);
//                }
//            }
//        }
//    }
}

package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 14:15 2020-10-26
 * @Description 给定一个9*9的二维数组，用字符填充‘.’使其结果为9*9的数独
 **/
public class SolveSudoku_37 {
    //    public void solveSudoku(char[][] board) {
//        HashMap<Integer, Integer>[] rows = new HashMap[9];
//        HashMap<Integer, Integer>[] columns = new HashMap[9];
//        HashMap<Integer, Integer>[] boxes = new HashMap[9];
//        for (int i = 0; i <9 ; i++) {
//            rows[i] = new HashMap<>();
//            columns[i] = new HashMap<>();
//            boxes[i] = new HashMap<>();
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[i][j] != '.') {
//                    int num = board[i][j];
//                    int boxes_index = (i / 3) * 3 + (j / 3);
//                    rows[i].put(num, 1);
//                    columns[j].put(num, 1);
//                    boxes[boxes_index].put(num, 1);
//                }
//            }
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[i][j] == '.') {
//                    int boxes_index = (i / 3) * 3 + (j / 3);
//                    for (int k = 1; k <10 ; k++) {
//                        if (!rows[i].containsKey(k) && !columns[j].containsKey(k) && !boxes[boxes_index].containsKey(k)) {
//                            rows[i].put(k, 1);
//                            columns[j].put(k, 1);
//                            boxes[boxes_index].put(k, 1);
//                            board[i][j] = (char)k;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//    }
    //用来标记值是否出现过
    boolean[][] rows = new boolean[9][9];
    boolean[][] columns = new boolean[9][9];
    boolean[][][] boxes = new boolean[3][3][9];
    boolean valid = false;
    List<int[]> space = new ArrayList<>();
    public void solveSudo(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    //保存需要插入值的位置
                    space.add(new int[]{i, j});
                } else {
                    int num = board[i][j];
                    rows[i][num-1] = true;
                    columns[j][num - 1] = true;
                    boxes[i / 3][j / 3][num - 1] = true;
                }
            }
        }
        dfs(board,0);
    }

    private void dfs(char[][]board, int pos) {
        if (pos == space.size()) {
            valid = true;
            return;
        }
        int[] index = space.get(pos);
        int i = index[0], j = index[1];
        for (int k = 0; k <9 ; k++) {
            if (!rows[i][k] && !columns[j][k] && !boxes[i / 3][j / 3][k]) {
                rows[i][k] = true;
                columns[j][k] = true;
                boxes[i / 3][j / 3][k] = true;
                board[i][j] = (char) (k + '0' + 1);
                dfs(board, pos + 1);
                rows[i][k] = false;
                columns[j][k] = false;
                boxes[i / 3][j / 3][k] = false;
            }
        }
    }
}

package com.test.demo.leetcode;

import java.util.HashMap;

/**
 * @Author :zjk
 * @Date :Create in 15:04 2020-10-25
 * @Description 给定一个9*9的数组，判断该数组是否满足数独条件
 * HashMap可以作为用来判断是否存在重复元素的工具，但是会产生较大的空间复杂度
 **/
public class IsValidSudoku_36 {
    public boolean isValidSudoku(char[][] board){
        //主要是判断行、列、子数独不存在相同的数字
        //创建三个Map来保存遍历到的数字
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i <9 ; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int num =  board[i][j];
                    int boxes_index = (i / 3) * 3 + j / 3;
                    if (rows[i].containsKey(num)) {
                        return false;
                    } else {
                        rows[i].put(num, 1);
                    }
                    if (columns[j].containsKey(num)) {
                        return false;
                    } else {
                        columns[j].put(num, 1);
                    }
                    if (boxes[boxes_index].containsKey(num)) {
                        return false;
                    } else {
                        boxes[boxes_index].put(num, 1);
                    }
                }
            }
        }
        return true;
    }
}

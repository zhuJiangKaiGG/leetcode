package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 16:21 2020-09-28
 * @Description Z字形转换
 **/
public class ZConvert {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        //创建n个列表，n代表行数。
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        //第一行为0
        int curRow = 0;
        //true则变换方向
        boolean goingDown = false;
        //从第一行开始，每次到第一行或者最后一行就变换方向
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

}

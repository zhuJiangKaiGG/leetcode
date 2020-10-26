package com.test.demo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

/**
 * @Author :zjk
 * @Date :Create in 19:27 2020-09-09
 * @Description
 **/
public class FinanceManager {
    @Autowired
    DataSource dataSource;
    static PreparedStatement pstmt = null;
    static Savepoint savePoint = null;
    public void TransactionDemo() throws SQLException {
        Connection connection = dataSource.getConnection();
        //设置不自动提交
        connection.setAutoCommit(false);

    }
    public void triggerDemo() throws SQLException {
        Connection connection = dataSource.getConnection();
        pstmt = connection.prepareStatement("UPDATE client SET client.c_password='12306' WHERE c_id=7");
        pstmt.executeUpdate();
    }
    public void test(){
        Scanner sc = new Scanner(System.in);
        //总共有几个数
        int n = sc.nextInt();
        int[] a = new int[n];
        //为数组赋值
        for (int i : a) {
            a[i] = sc.nextInt();
        }
        //需要打印的起始层和结束层
        int level1 = sc.nextInt();
        int level2 = sc.nextInt();
        int c = level1;
        for (double i = Math.pow(2, level1-1) - 1; i < Math.pow(2,level2-1)-1; i++) {
            if (i == Math.pow(2, c - 1)) {
                c++;
                System.out.println();
            }else {
                int b =(int) i;
                System.out.print(a[b]);
            }
        }
    }

}

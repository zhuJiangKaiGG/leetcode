package com.test.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.test.demo.mapper")
public class DemoApplication {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);


//                Scanner scanner = new Scanner(System.in);
//                int n = scanner.nextInt();
//                int[] a = new int[n];
//                for(int i=0;i<n;i++){
//                    a[i] = scanner.nextInt();
//                }
//                int a1 = scanner.nextInt();
//                int a2 = scanner.nextInt();
//                int c = 1;
//                int num = 1;
//                int cnum = 0;
//                for(int i=0;i<n;i++){
//                    if(c>=a1&&c<=a2&&a[i]!=-1)
//                        System.out.print(a[i]+" ");
//                    cnum++;
//                    if(cnum==num){
//                        cnum=0;
//                        num*=2;
//                        c++;
//                        if(c>a1)
//                            System.out.println();遍历完这一层的数换行
//                        if(c>a2)
//                            break;
//                    }
//                }
        Scanner sc = new Scanner(System.in);
        //总共有几个数
        int n = sc.nextInt();
        int[] a = new int[n];
        //为数组赋值
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        //需要打印的起始层和结束层
        int level1 = sc.nextInt();
        int level2 = sc.nextInt();
        int c = level1;
        for (double i = Math.pow(2, level1-1) - 1; i < Math.pow(2,level2)-2; i++) {
            if (i == (Math.pow(2, c)-2)) {//用来判断是否遍历完这一层
                int b =(int) i;
                if (a[b]!=-1)
                    System.out.print(a[b]);
                c++;
                System.out.println();
            }else {
                int b =(int) i;
                if (a[b]!=-1)
                    System.out.print(a[b]);
            }
        }

            }


}

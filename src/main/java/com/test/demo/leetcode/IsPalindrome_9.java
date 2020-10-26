package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 15:53 2020-10-05
 * @Description
 * 判断一个整数是不是回文数
 **/
public class IsPalindrome_9 {
    public boolean isPalindrome(int x) {
        //要考虑0的情况
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int result=0,a=0,n=x;
        while(x!=0){
            //可以用如下两行代码来获得x的任何一个数字
            a=x%10;
            x=x/10;
            result=result*10+a;
        }
        if(result!=n){
            return false;
        }
        return true;
    }
}

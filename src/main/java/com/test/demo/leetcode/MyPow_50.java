package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:20 2020-11-08
 * @Description 给定一个double类型的数x以及整数类型的n, 实现x的n字方
 *  暴力法会超时。
 *  利用递归+分治。暴力法是将给定的数乘n（n>1）次，当n为负数时，即是1/n乘（n<-1）n次
 *  分治的思想是每次将当前的结果相乘，例如以x=2为例，刚开始是2*2，下一次是（2*2）*（2*2），下一次是（2*2*2*2）*（2*2*2*2）
 *  可是从前往后很难决定何时应该对当前的数做出正确的选择，因为例如n等于70，71这样不规则的数时按照不能够按照上面的规则来写。
 *  因此可以选择从后向前来考虑（n/2）。
 *  递归的考虑：
 *  首先得明白递归得终止条件是什么，这里由于每次递归改变得参数是n,因此当n为0时，返回1。
 *  第二需要知道这个递归中应该进行什么操作，我们得思想是从n/2来计算，因此每次计算完我们需要得到n次幂得值，因此要将n/2次幂的值再求二次幂，
 *  即将两个n/2次幂相乘得到n次幂。
 *  注意的细节：
 *  n的奇偶性对于递归执行的操作有影响，当为偶数时直接y*y,奇数时y*y*x
 *  当n为负数时要注意溢出的问题
 **/
public class MyPow_50 {
    public static double myPow(double x, int n) {
        long N = n;
        // 当N为负数时，只要求得-N的结果再取倒数就可以
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    private static double quickMul(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
    public static void main(String[] args) {
        double v = myPow(1.00000, 2147483647);
        System.out.println(v);
    }
}

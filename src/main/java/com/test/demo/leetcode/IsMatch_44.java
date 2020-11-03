package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:05 2020-11-02
 * @Description 给定一个字符串和一个字符模式，实现一个支持“？”和“*”的通配符匹配
 **/
public class IsMatch_44 {
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        //布尔数组默认的值为false
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;//当s与p都为空时，为true
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == 's') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //如果我们不使用这个星号，那么就会从 dp[i][j-1]转移而来；如果我们使用这个星号，那么就会从 dp[i-1][j]转移而来
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

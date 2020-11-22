package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:59 2020-11-19
 * @Description 给定一个m*n的矩阵，起点为左上角，终点为右下角，算出起点到终点的不同路径的条数，其中路径中的下一个点只能是当前点右边或下边的点
 * 使用动态规划。
 * dp[i][j] 表示从点（0，0）到达点（i，j）的路径数。
 * 动态规划方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * 动态规划初始值：由于第一行和第一列都的路径数都是1，所有dp[i][0],dp[0][j]都为1
 * 最后的结果即为dp[n-1][m-1](注意题目给的n为行m为列)
 * 还可以优化，因为只需要存储上面和左边两个点的信息所以可以只用一个m数组
 **/
public class UniquePaths_62 {
    public static int uniquePath(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][m] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
    /**
     * public int uniquePaths(int m, int n) {
     *     int[] dp = new int[m];
     *     Arrays.fill(dp, 1);
     *     for (int j = 1; j < n; j++)
     *         for (int i = 1; i < m; i++)
     *             dp[i] += dp[i - 1];
     *     return dp[m - 1];
     * }
     *
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-di-gui-gong-shi-deng-4chong-jie-j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}

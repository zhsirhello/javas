package leetcode;

/**
 * 从矩阵（0，0）到（m,n）各个元素相加最小的一条路径和为多少
 *
 * 动态规划。
 * 从（0，0）到（0，1）...（1，1）之类的点最短路径求和。一层一层的计算，则到右下角的点即最小了
 */
public class MinimumPathSum {
        public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}

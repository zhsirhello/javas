package leetcode;

/**
 * 数组中各个元素代表可以跳动的步数，从第一格开始，到最后一个元素，最小的跳跃次数
 *
 * 贪心算法
 * 好好理解一下，为什么这么做可以
 */
public class JumpGameii {
    public int jump(int[] A) {
        int[] dp = new int[A.length]; // dp存放都到各点的最小步数
        for (int i = 0; i < dp.length; i ++) {
            int maxPosition = Math.min(i + A[i], A.length - 1); // 从i点出发能走的最远距离
            for (int j = i + 1; j <= maxPosition; j ++) {
                if(dp[j] == 0) dp[j] = dp[i] + 1; // 如果位置没被走过,则到达j点的步数为dp[i]+1
            }
            if(dp[A.length - 1] != 0) break; // 当第一次到达终点时,肯定是到达终点最短的步数
        }
        return dp[A.length - 1];
    }
}

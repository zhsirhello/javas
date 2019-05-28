package leetcode;

/**
 * 爬楼梯，有n阶，一次爬一阶或者两阶，有多少种不同的攀爬方法
 */
public class ClimbStairs {

    /*  暴力递归  此题超时
       public int climbStairs(int n) {
           if(n == 1)
               return 1;
           if(n == 2)
               return 2;
           return climbStairs(n - 1) + climbStairs(n -2);
       }
       */
    //常规时间复杂度O(n)算法
    public int climbStairs(int n) {
        if(n == 2)
            return 2;
        if(n == 1)
            return 1;
        int tmp = 0;
        int pre = 1;
        int res = 2;
        for(int i = 3; i <= n; i++){
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
    /*
    //动态规划   空间和时间复杂度都为O(n)，
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    */
}

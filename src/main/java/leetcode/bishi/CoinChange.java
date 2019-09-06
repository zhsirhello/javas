package leetcode.bishi;

/**
 * leetcode322
 * 零钱找零，币的数目最少。
 * 输入数组代表零散钱的金额，输入值代表总共的钱。
 */
public class CoinChange {
    public int coinchange(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}

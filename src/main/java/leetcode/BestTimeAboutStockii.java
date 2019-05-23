package leetcode;

/**
 * 假设您有一个数组，其中第i个元素是第i天给定股票的价格。
 * 设计算法以找到最大利润。 您最多可以完成两笔交易。
 * 注意：
 * 您不得同时进行多笔交易（即，您必须在再次购买之前卖出股票）。
 *
 * 以下代码思路
 * 分别计算出i之前和之后的最大利润pre[i],post[i]
 *     * 再以i为分割求出两次交易的最大利润（在i处可能卖出再买入，相当于就一次交易）
 *     * 空间换时间，时间复杂度O(n)，空间复杂度O(n)
 */
public class BestTimeAboutStockii {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int[]pre=new int[prices.length];
        int []post=new int[prices.length];
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            pre[i]=Math.max(pre[i-1],prices[i]-min);
        }
        int max=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            max=Math.max(max,prices[i]);
            post[i]=Math.max(post[i+1],max-prices[i]);
        }
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            maxProfit=Math.max(maxProfit,pre[i]+post[i]);
        }
        return  maxProfit;
    }
}

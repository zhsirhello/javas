package leetcode;

/**
 * 假设您有一个数组，其中第i个元素是第i天给定股票的价格。
 * 设计算法以找到最大利润。 您可以根据需要完成尽可能多的交易（即，多次买入并卖出一股股票）。 但是，您可能不会同时进行多笔交易
 * （即，您必须在再次购买之前卖出股票）。
 *
 * 判断相邻是否递增，因为连续递增可以合起来看为一次买入卖出操作，所以统计所有递增量即可
 * 想想为什么是这样？
 */
public class BestTimeAboutStocki {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<2)
            return 0;
        int res = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                res += prices[i]-prices[i-1];
        }
        return res;
    }
}

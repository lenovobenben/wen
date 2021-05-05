package arr;

/**
 * 121. 买卖股票的最佳时机
 */
public class Solution5 {

    // 动态规划 前i天的最大收益 = max{前i-1天的最大收益， 第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length - 1];
    }

    public int maxProfit_(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            } else {
                min = Math.min(min, prices[i]);
            }
        }
        return maxProfit;
    }
}

package bak.me;

/**
 * 假设你有一个数组，其中第 i 个元素是股票在第 i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
 * 请你设计一个算法来计算可以获得的最大收益。
 */
public class Solution7 {

    public int maxProfit (int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {// i 天买入
            for (int j = i; j < n; j++) {// j 天卖出
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }

}

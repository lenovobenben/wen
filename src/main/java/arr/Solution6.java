package arr;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class Solution6 {
    // 贪心思路。 该算法仅可以用于计算，但 计算的过程并不是真正交易的过程
    // 此算法需要严格的数学证明
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            int delt = prices[i] - prices[i - 1];
            if (delt > 0) {
                profit = profit + delt;
            }
        }
        return profit;
    }
}
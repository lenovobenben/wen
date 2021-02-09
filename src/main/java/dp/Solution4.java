package dp;

import java.util.Arrays;

/**
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 */
public class Solution4 {

    public int minMoney(int[] arr, int aim) {
        //Arrays.sort(arr);// 很有必要排序
        int[] dp = new int[aim];
        // 初始化 只需要一个硬币就能拼凑 aim 的情况
        for (int i = 0; i < arr.length; i++) {
            dp[arr[i] - 1] = 1;
        }

        for (int i = 0; i < aim; i++) {
            if (dp[i] == 0) {// 需要计算
                dp[i] = Integer.MAX_VALUE;// 默认最大
                for (int j = 0; j < arr.length; j++) {
                    if (i - arr[j] < 0) {// 比如：5的硬币永远拼凑不出4！后续大于5的硬币，更拼凑不出4。因此 break
                        break;
                    }
                    if (dp[i - arr[j]] == Integer.MAX_VALUE) {// 无解，则跳过当前 arr[j]
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        return dp[aim - 1] == Integer.MAX_VALUE ? -1 : dp[aim - 1];
    }

}

package bak.me;

import java.util.Arrays;

/**
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 */
public class Solution10 {

    public int minMoney(int[] arr, int aim) {
        Arrays.sort(arr);// 很有必要排序
        int[] dp = new int[aim];
        // 初始化 只需要一个硬币就能拼凑 aim 的情况
        for (int i = 0; i < arr.length; i++) {
            dp[arr[i] - 1] = 1;
        }

        for (int i = 0; i < aim; i++) {
            if (dp[i] == 0) {// 需要计算
                dp[i] = -1;// 默认最小值为 -1 （不可拼凑）
                for (int j = 0; j < arr.length; j++) {
                    if (i - arr[j] < 0) {// 比如：5的硬币永远拼凑不出4！后续大于5的硬币，更拼凑不出4。因此 break
                        break;
                    }
                    if (dp[i - arr[j]] == -1) {// 无解，则跳过当前 arr[j]
                        continue;
                    }
                    if (dp[i] == -1) {// 需要初始化
                        dp[i] = dp[i - arr[j]] + 1;// 最近的一个 dp 加一个币
                    } else {// 和上一个保存的值比较。迭代取得最小值
                        dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                    }
                }
            }
        }

        return dp[aim - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        int aim = 15;
        new Solution10().minMoney(arr, aim);
    }
}

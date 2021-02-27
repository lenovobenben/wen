package dp;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为 O(n)
 */
public class Solution2 {
    // 无后效性
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[array.length];// dp[i] 以 i 结尾的所有子数组的最大和
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + array[i];
            } else {
                dp[i] = array[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }


    public int FindGreatestSumOfSubArray2(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int tempSum = 0;
                for (int k = i; k <= j; k++) {
                    tempSum = tempSum + array[k];
                }
                max = Math.max(max,tempSum);
            }
        }
        return max;
    }

}

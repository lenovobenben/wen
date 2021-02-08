package dp;

/**
 * 已知正整数n，将其分为0到多个25、10、5、1这四个数的和。如n为11可分为一个10和一个1，或者分为两个5和一个1。
 * 返回n有多少种分法。保证n小于等于100000，请将答案Mod 1000000007 以防止溢出。
 * 测试样例：
 * 6
 * 返回：2
 */
public class Solution3 {
    public int countWays(int n) {
        int[] coin = new int[]{1, 5, 10, 25};// 从小到大排序
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coin.length; i++) {// 遍历 1 2 5。第一次是每个数只有1组成，第二次是 1+2 组成，第三次是 1+2+5 组成
            for (int j = coin[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin[i]]) % 1000000007;// dp[j]是累加的   dp[j] + dp[j-1]
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().countWays(10));
    }
}

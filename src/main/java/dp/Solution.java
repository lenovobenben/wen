package dp;

import java.math.BigInteger;

/**
 * 斐波那契数列
 * （从0开始，第0项为0，第1项是1）
 * 0 1 1 2 3 5 8 13 21 34 55 89
 */
public class Solution {

    /**
     * 动态规划
     */
    public BigInteger Fibonacci(int n) {
        if (n==0) {
            return new BigInteger("0");
        } else if (n==1) {
            return new BigInteger("1");
        } else {
            BigInteger[] dp = new BigInteger[n + 1];// dp[i] 对应着 i的斐波那契值
            dp[0] = new BigInteger("0");;// 初始值
            dp[1] = new BigInteger("1");;// 初始值
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i-1].add(dp[i-2]);
            }
            return dp[n];
        }
    }


    /**
     * 递归 存在大量重复计算
     */
    public int Fibonacci2(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci2(n - 1) + Fibonacci2(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(10000));
    }
}

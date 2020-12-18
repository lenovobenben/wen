package bak.me;

/**
 * 给定一个正整数int n，从0开始加到n，每次可增加1、2或3，直到其大于等于n，请返回一个数，代表加到n的方案的个数。
 * 保证n小于等于100000，并为了防止溢出，请将结果Mod 1000000007。
 */
public class GoUpstairs {
    public int countWays(int n) {

        // 特殊处理
        if (n==1) {
            return 1;
        } else if (n==2) {
            return 1 + 1;
        } else if (n==3) {
            return 1 + 2 + 1;// 一种3方案。两种2+1方案。一种1+1+1方案
        }

        // int[i] 代表加到 i+1 的方案数
        int[] dp = new int[n];
        // 初始化
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < n; i++) {
            dp[i] = ((dp[i-1] + dp[i-2])%1000000007 + dp[i-3])%1000000007;
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new GoUpstairs().countWays(36196));
    }
}

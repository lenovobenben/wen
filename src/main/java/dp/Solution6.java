package dp;

/**
 * 62. 不同路径
 *
 * 给定两个正整数int x,int y，代表一个x乘y的网格，
 * 现有一个机器人要从网格左上角顶点走到右下角，每次只能走一步且只能向右或向下走，
 * 返回机器人有多少种走法。保证x＋y小于等于12。
 */
public class Solution6 {
    /**
     * 动态规划的思路
     */
    public int countWays(int x, int y) {
        if (x==1 || y==1) {
            return 1;
        }
        // 保存从 0,0 到 x-1,y-1 的走法
        int[][] dp = new int[x][y];
        // 初始化
        for (int i = 0; i < x; i++) {
            dp[i][0] = 1;// 第0列
        }
        for (int j = 0; j < y; j++) {
            dp[0][j] = 1;// 第0行
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];// 状态转移方程
            }
        }
        return dp[x-1][y-1];
    }

}

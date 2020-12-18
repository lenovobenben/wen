package bak.me;

/**
 * 给定两个正整数int x,int y，代表一个x乘y的网格，
 * 现有一个机器人要从网格左上角顶点走到右下角，每次只能走一步且只能向右或向下走，
 * 返回机器人有多少种走法。保证x＋y小于等于12。
 */
public class Robot {

    /**
     * 机器人在 X*Y 的矩阵中走，每一步都有两种选择：要么向下、要么向右。
     * <p>
     * 如果向下走，问题就变成：求 (X-1)*Y 矩阵中机器人的走法；
     * <p>
     * 如果向右走，问题就变成：求 X*(Y-1) 矩阵中机器人的走法；
     * <p>
     * 显然是递归的思想！
     * <p>
     * 既然是递归，再考虑退出条件：当整个矩阵只有一行 或 一列的时候只有一种走法。
     */
    public int countWays(int x, int y) {

        if (x == 1 || y == 1) {
            return 1;
        } else {
            return countWays(x, y - 1) + countWays(x - 1, y);
        }

    }


    /**
     * 动态规划的思路
     */
    public int countWays2(int x, int y) {

        if (x==1 || y==1) {
            return 1;
        }

        // 保存从 0,0 到 x-1,y-1 的走法
        int[][] dp = new int[x][y];

        // 初始化
        for (int i = 0; i < x; i++) {
            dp[i][0] = 1;// 每一行的第一列
        }
        for (int j = 0; j < y; j++) {
            dp[0][j] = 1;// 第一行的每一列
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                // 状态转移方程
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[x-1][y-1];
    }

}

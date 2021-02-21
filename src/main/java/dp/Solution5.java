package dp;

import java.util.Arrays;

/**
 * 给定一个int数组men，代表参加一场游戏依次来的每个人的身高，同时给定总人数n，
 * 要求一个人站在另一个人肩膀上，且下面的人比上面的人要更高一点。请返回最多能够叠的人数。
 * 注意参加游戏的人的先后顺序与原序列中的顺序应该一致保证，且n小于等于500。
 *
 * 最大递增子序列
 *
 * 测试样例：
 * [1,6,2,5,3,4],6
 * 返回：4
 */
public class Solution5 {
    public int getHeight(int[] men, int n) {
        int[] dp = new int[men.length];
        if (men.length==1) {
            return 1;
        }
        Arrays.fill(dp,1);
        int ret = 1;
        for (int i = 0; i < men.length; i++) {// 计算 dp[i] 以 i 结尾的最长递增子序列的长度
            for (int j = 0; j < i; j++) {
                if (men[j] < men[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ret  = Math.max(dp[i],ret);
        }

        return ret;
    }
}

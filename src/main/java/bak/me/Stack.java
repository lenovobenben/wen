package bak.me;

/**
 * 给定一个int数组men，代表参加一场游戏依次来的每个人的身高，同时给定总人数n，
 * 要求一个人站在另一个人肩膀上，且下面的人比上面的人要更高一点。
 * 请返回最多能够叠的人数。注意参加游戏的人的先后顺序与原序列中的顺序应该一致保证，且n小于等于500。
 * <p>
 * 等价于：最长递增子序列
 * <p>
 * <p>
 * 不会做！！！
 */
public class Stack {

    public int getHeight(int[] men, int n) {

        // men [2, 6, 1, 5, 8, 3, 4, 7]
        // dp  [1, 2, 1, 2, 3, 2, 3, 4]
        // dp 是以当前下标为结束的最大递增数列长度！！！
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int max = 0; // 小于 men[i]的，从 0 到 i-1 的 dp 最大值（如果大于men[i]，对i位结尾无助力）
            for (int j = i - 1; j >= 0; j--) {
                if (men[i] > men[j]) {
                    max = Integer.max(max, dp[j]);
                }
                dp[i] = max + 1;// 小于 men[i]，因此可以追加 men[i]，形成多一位的序列
                res = Integer.max(res, dp[i]);// 反复迭代，保留最大值
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 1, 5, 8, 3, 4, 7};
        new Stack().getHeight(arr, arr.length);
    }

}

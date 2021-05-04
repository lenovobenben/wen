package dp;

/**
 * 198. 打家劫舍
 */
public class Solution7 {

    /**
     * 如果只有一间房屋，则偷窃该房屋。
     * 如果只有两间房屋，选择其中金额较高的房屋进行偷窃。
     * 对于第 k (k>2) 间房屋，有两个选项：
     * 偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额 = 前 k-2 间房屋的最高总金额 + 第 k 间房屋的金额。
     * 不偷窃第 k 间房屋，偷窃总金额 = 前 k-1 间房屋的最高总金额。
     * 在两个选项中选择偷窃总金额较大的选项即可。
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }
}

package twoPointers;

/**
 * 209. 长度最小的子数组
 */
public class Solution4 {

    /**
     * 双指针思路：
     * end 右移，增大sum
     * start 右移，减小sum
     * 反复调节 start 和 end 的窗口大小，不断重置 ret 即可
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ret = Integer.MAX_VALUE;// 返回值，默认最大值
        int sum = 0;// 临时的累加和
        int start = 0;
        int end = 0;
        int flag = 1;// 上次增加 end 为 1。上次增加 start 为 -1

        while (end <= nums.length) {

            if (nums[end] >= target) return 1;// 特殊处理，直接返回1

            if (flag == 1) {
                sum = sum + nums[end];// 累加 end 的值，则为新的 sum
            } else {// 为 -1
                sum = sum - nums[start - 1];// 减去 start-1 的值，则为新的 sum
            }

            if (sum >= target) {// 记录最小值，右移 start
                ret = Math.min(ret, end - start + 1);
                start++;
                flag = -1;
            } else {// 右移 end
                end++;
                flag = 1;
            }
        }

        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}

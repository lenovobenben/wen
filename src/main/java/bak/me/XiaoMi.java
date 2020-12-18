package bak.me;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2。[4,3]是最小长度
 */
public class XiaoMi {


    /**
     * 双指针思路：
     * end 右移，增大sum
     * start 右移，减小sum
     * 反复调节 start 和 end 的窗口大小，不断重置 ret 即可
     */
    public int findMinLen(int[] nums, int s) {
        int ret = Integer.MAX_VALUE;// 返回值，默认最大值
        int sum = 0;// 临时的累加和
        int start = 0;
        int end = 0;
        int flag = 1;// 上次增加 end 为 1。上次增加 start 为 -1

        while (true) {
            if (end == nums.length) break;// 循环结束
            if (nums[end] >= s) return 1;// 特殊处理，直接返回1

            if (flag == 1) {
                sum = sum + nums[end];// 累加 end 的值，则为新的 sum
            } else {// 为 -1
                sum = sum - nums[start - 1];// 减去 start-1 的值，则为新的 sum
            }

            if (sum >= s) {// 记录最小值，右移 start
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

    public static void main(String[] args) {
        System.out.println(new XiaoMi().findMinLen(new int[]{2, 3, 1, 2, 4, 3, 2}, 7));
    }
}

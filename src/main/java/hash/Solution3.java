package hash;

/**
 * 剑指 Offer 03. 数组中重复的数字
 */
public class Solution3 {

    public int findRepeatNumber(int[] nums) {
        // 原地哈希
        // [2, 3, 1, 0, 2, 5, 3]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] != nums[i]) {
                    // 互换 nums[i] 和 nums[nums[i]]
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                } else {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}

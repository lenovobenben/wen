package twoPointers;

/**
 * 剑指 Offer 57. 和为s的两个数字
 */
public class Solution5 {

    /**
     * 双指针思路
     * 经过严格证明：并不会丢失解！！！
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                break;
            }
        }
        return new int[]{nums[i], nums[j]};
    }

}

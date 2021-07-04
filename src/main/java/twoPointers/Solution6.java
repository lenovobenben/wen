package twoPointers;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Solution6 {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if ((nums[start] & 1) == 1) {// start是奇数
                start++;
                continue;
            }
            if ((nums[end] & 1) == 0) {// end是偶数
                end--;
                continue;
            }
            if ((nums[start] & 1) == 0 && (nums[end] & 1) == 1) {// start偶数 同时 end奇数。互换
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return nums;
    }
}

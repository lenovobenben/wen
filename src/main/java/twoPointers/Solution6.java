package twoPointers;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Solution6 {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if ((nums[start] & 1) == 1) {// 奇数
                start++;
            } else {// 偶数，等待互换
                if ((nums[end] & 1) == 1) {// 奇数
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                } else {// 也是偶数
                    end--;
                }
            }
        }
        return nums;
    }
}

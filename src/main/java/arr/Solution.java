package arr;

/**
 * 189. 旋转数组
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);// 全部翻转
        reverse(nums, 0, k - 1);// 翻转前 k 个
        reverse(nums, k, nums.length - 1);// 翻转剩下的
    }

    public void reverse(int[] nums, int start, int end) {// 翻转
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
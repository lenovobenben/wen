package twoPointers;

import java.util.*;

/**
 * 15. 三数之和 (3Sum)
 * 经典双指针题目：给定一个整数数组 nums，判断是否存在三个元素 a，b，c，
 * 使得 a + b + c = 0 ？找出所有和为 0 且不重复的三元组。
 * 
 * 核心思路：
 * 1. 对数组进行排序 (关键：为了方便去重和使用双指针)。
 * 2. 遍历数组，固定第一个数 nums[i]。
 * 3. 使用左指针 L = i + 1, 右指针 R = n - 1，寻找 nums[i] + nums[L] + nums[R] == 0。
 * 4. 严格去重 (跳过相同的 nums[i], nums[L], nums[R])。
 */
public class Solution7 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        // 1. 排序
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 如果第一个数已经大于 0，三数之和一定大于 0 (已排序)
            if (nums[i] > 0) break;

            // 2. 固定第一个数去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int L = i + 1;
            int R = n - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    
                    // 3. 左右指针去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        
        // 示例 1: 标准情况
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("测试 1 - nums: " + Arrays.toString(nums1));
        System.out.println("结果: " + sol.threeSum(nums1)); // 输出: [[-1, -1, 2], [-1, 0, 1]]

        // 示例 2: 全零
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("测试 2 - nums: [0, 0, 0, 0]");
        System.out.println("结果: " + sol.threeSum(nums2)); // 输出: [[0, 0, 0]]

        // 示例 3: 无解
        int[] nums3 = {1, 2, 3};
        System.out.println("测试 3 - nums: [1, 2, 3]");
        System.out.println("结果: " + sol.threeSum(nums3)); // 输出: []
    }
}

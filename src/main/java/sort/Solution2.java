package sort;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class Solution2 {

    /**
     * 原地算法
     * 逆序合并到 nums1
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int re = m + n - 1;// 逆序下标
        while (re >= 0 && p2 >= 0 && p1 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[re] = nums1[p1];
                p1--;
            } else {
                nums1[re] = nums2[p2];
                p2--;
            }
            re--;
        }

        if (p1 < 0) {
            while (re >= 0) {
                nums1[re] = nums2[p2];
                p2--;
                re--;
            }
        }
    }

}
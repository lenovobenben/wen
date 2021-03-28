package binarySearch;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组（不重复），找出这n个数中缺失的那个数，要求O(n)尽可能小。
 * [0,1,2,3,4,5,7]
 * 缺失 6
 */
public class Solution {
    public int missingNumber(int[] a) {
        // 特殊处理 最后一位
        if (a[a.length - 1] == a.length - 1) {
            return a.length;
        }

        // 特殊处理 第一位
        if (a[0] != 0) {
            return 0;
        }

        int start = 0;
        int end = a.length - 1;
        while (true) {
            if (end - start == 1) {// 相差1时，大的下标值即为结果
                return end;
            }
            int temp = (start + end) / 2;
            if (a[temp] > temp) {
                end = temp;
            } else {// 此时 a[temp] == temp 。 不存在小于的情况
                start = temp;
            }
        }
    }
}
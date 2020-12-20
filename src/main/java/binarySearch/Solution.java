package binarySearch;

/**
 * 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组（不重复），找出这n个数中缺失的那个数，要求O(n)尽可能小。
 * [0,1,2,3,4,5,7]
 * 缺失 6
 */
public class Solution {

    public int solve(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 经典 二分查找
     */
    public int binarySearch(int[] arr, int hkey) {
        int result = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;//防止溢位
            if (arr[mid] > hkey)
                end = mid - 1;
            else if (arr[mid] < hkey)
                start = mid + 1;
            else {
                result = mid;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 8, 9};
        System.out.println(new Solution().binarySearch(arr, 7));
    }
}

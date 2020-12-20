package binarySearch;

/**
 * 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组（不重复），找出这n个数中缺失的那个数，要求O(n)尽可能小。
 * [0,1,2,3,4,5,7]
 * 缺失 6
 */
public class Solution {
    public int solve(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (true) {
            if (end - start == 1) {
                return  end;
            }
            int temp = (start + end) / 2;
            if (a[temp] > temp) {
                end = temp;
            } else {
                start = temp;
            }
        }
    }
}

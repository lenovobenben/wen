package bit;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 一个数组存放若干整数。
 * 一个数出现奇数次，其余数均出现偶数次，找出这个出现奇数次的数。
 */
public class Solution {
    public int findNum(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret = ret ^ arr[i];
        }
        return ret;
    }

    public int findNum2(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }

        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2, 5, 1, 1, 4, 5, 4};// 1 1 2 2 4 4 5 5 3
        System.out.println("------- " + new Solution().findNum2(arr));
    }
}

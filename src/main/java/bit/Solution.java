package bit;

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

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2, 5, 1, 1, 4, 5, 4};
        System.out.println(new Solution().findNum(arr));
    }
}

package bak.me;

/**
 * 连续子数组的最大和
 * 超级有名的算法题
 */
public class SubArrSum {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, -7, 5, 2, -1, 2, -4, 3};
        System.out.println(new SubArrSum().maxSubSum(arr, arr.length));
    }

    /**
     * 最优方法，时间复杂度O（n）
     * 和最大的子序列的第一个元素肯定是正数
     * 因为元素有正有负，因此子序列的最大和一定大于0
     */
    public int maxSubSum(int[] arr, int len) {
        int i;
        int maxSum = 0;
        int curSum = 0;
        for (i = 0; i < len; i++) {
            curSum += arr[i];
            if (curSum > maxSum)
                maxSum = curSum;
            //如果累加和出现小于0的情况，
            //则和最大的子序列肯定不可能包含前面的元素，
            //这时将累加和置0，从下个元素重新开始累加
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}

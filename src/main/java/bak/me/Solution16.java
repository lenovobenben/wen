package bak.me;

/**
 * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 * https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=190&&tqId=36005&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class Solution16 {

    /**
     * 全部装满水之后，整个数组只有三种情况：
     * 纯递增，
     * 纯递减，
     * 先递增后递减
     */
    public long maxWater(int[] arr) {
        int len = arr.length;
        int[] maxArr = new int[len];// 装满水的数组（左边递增，右边递减）
        // 求出最大值的下标（如果存在多个最大值，则取得最左边的那个）
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        // 初始化 特殊值
        maxArr[maxIndex] = max;
        maxArr[0] = arr[0];
        maxArr[len - 1] = arr[len - 1];
        // 以最大值为分界线，左边递增，右边递减
        for (int i = 1; i < maxIndex; i++) {
            maxArr[i] = Math.max(arr[i], maxArr[i - 1]);
        }
        for (int i = len - 2; i > maxIndex; i--) {
            maxArr[i] = Math.max(arr[i], maxArr[i + 1]);
        }

        long count = 0L;
        for (int i = 0; i < len; i++) {
            long temp = maxArr[i] - arr[i];// 防止溢出，强制为 long 类型
            count = count + temp;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        new Solution16().maxWater(arr);
    }
}

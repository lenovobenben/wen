package arr;

/**
 * 42. 接雨水
 */
public class Solution2 {
    public int trap(int[] arr) {
        if (arr.length <= 2) {
            return 0;
        }
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

        int count = 0;
        for (int i = 0; i < len; i++) {
            int temp = maxArr[i] - arr[i];
            count = count + temp;
        }
        return count;
    }
}
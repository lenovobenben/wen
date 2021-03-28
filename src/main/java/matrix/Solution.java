package matrix;

/**
 * 718. 最长重复子数组
 */
public class Solution {

    public int findLength2(int[] arr1, int[] arr2) {
        int maxLen = 0;
        for (int i = 0; i < arr1.length; i++) {// 每行第1列，斜下方45°
            int temp = 0;// 临时长度
            for (int j = 0, k = i; j < arr2.length && k < arr1.length; j++, k++) {
                if (arr1[k] == arr2[j]) {// 相同
                    temp++;// 临时长度+1
                    maxLen = Math.max(maxLen, temp);// 迭代最大值
                } else {// 不相同，重置 临时长度
                    temp = 0;
                }
            }
        }
        return maxLen;
    }

    public int findLength(int[] A, int[] B) {
        int a = this.findLength2(A, B);
        int b = this.findLength2(B, A);
        return Math.max(a, b);
    }
}
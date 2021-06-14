package twoPointers;

/**
 * 11. 盛最多水的容器
 */
public class Solution3 {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int ret = 0;
        while (end - start > 0) {
            int temp = 0;
            if (height[start] > height[end]) {
                temp = height[end] * (end - start);
                end--;
            } else {
                temp = height[start] * (end - start);
                start++;
            }
            ret = Math.max(ret, temp);
        }
        return ret;
    }
}

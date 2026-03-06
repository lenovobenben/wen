package stackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Solution4 {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>(); // 单调递增栈，存下标

        for (int i = 0; i <= heights.length; i++) {
            int curHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > curHeight) {
                int h = heights[stack.pop()];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftIndex - 1;
                maxArea = Math.max(maxArea, h * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] a = {2, 1, 5, 6, 2, 3};
        int[] b = {2, 4};

        System.out.println(Arrays.toString(a) + " -> " + s.largestRectangleArea(a)); // 10
        System.out.println(Arrays.toString(b) + " -> " + s.largestRectangleArea(b)); // 4
    }
}

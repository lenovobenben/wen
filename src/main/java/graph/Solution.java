package graph;

import java.util.*;

/**
 * 经典算法：最小生成树 (Minimum Spanning Tree, MST)
 * 实现：Prim 算法 (基于最小堆优化)
 * 题目：1584. 连接所有点的最小费用
 */
public class Solution {

    /**
     * 使用 Prim 算法求最小生成树。
     * 图是隐式完全图，任意两点边权为曼哈顿距离。
     *
     * @param points 点坐标，points[i] = [xi, yi]
     * @return 最小生成树的总权重
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return 0;
        }

        int totalWeight = 0;
        int count = 0;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.poll();
            int w = curr[0];
            int u = curr[1];

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            totalWeight += w;
            count++;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int weight = distance(points[u], points[v]);
                    if (weight < minDist[v]) {
                        minDist[v] = weight;
                        pq.offer(new int[]{weight, v});
                    }
                }
            }
        }

        return totalWeight;
    }

    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points = {
            {0, 0},
            {2, 2},
            {3, 10},
            {5, 2},
            {7, 0}
        };

        System.out.println("最小生成树的总权重: " + sol.minCostConnectPoints(points)); // 输出: 20
    }
}

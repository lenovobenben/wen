package graph;

import java.util.*;

/**
 * Dijkstra 算法实现 (基于最小堆优化)
 * 解决单源最短路径问题 (Single Source Shortest Path)
 * 适用于：带权图，且所有边权均为非负数
 * 时间复杂度：O(E * logE)，其中 E 为边数
 */
public class Solution2 {

    /**
     * Dijkstra 核心逻辑
     * @param times 边信息 [起点, 终点, 权重]
     * @param n 节点总数 (假设节点编号从 1 到 n)
     * @param k 起点
     * @return 从 k 出发到达所有节点的最短时间中的最大值。如果无法到达所有节点，返回 -1。
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. 构建邻接表: 节点 -> List<{终点, 权重}>
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // 2. 初始化距离数组，初始值为正无穷
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 3. 优先队列 (最小堆): 存储 {当前总权重, 节点编号}，按权重从小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            // 剪枝：如果当前弹出的距离已经大于已知的最短距离，则跳过
            if (d > dist[u]) continue;

            // 遍历邻居
            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    // 松弛操作 (Relaxation)
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.offer(new int[]{dist[v], v});
                    }
                }
            }
        }

        // 4. 计算结果：所有节点最短路径中的最大值
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // 有节点无法到达
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        
        // 示例 1:
        // 2 -> 1 (权 1), 2 -> 3 (权 1), 3 -> 4 (权 1)
        // 起点: 2, 节点数: 4
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println("测试 1 - 最大延迟时间: " + sol.networkDelayTime(times, n, k)); // 输出: 2

        // 示例 2: 无法到达所有节点
        int[][] times2 = {{1, 2, 1}};
        System.out.println("测试 2 - 无法到达所有节点: " + sol.networkDelayTime(times2, 2, 2)); // 输出: -1
    }
}

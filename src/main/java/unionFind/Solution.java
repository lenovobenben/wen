package unionFind;

/**
 * 经典算法：并查集 (Union-Find)
 * 解决问题：动态连通性、社交网络好友关系、省份/岛屿合并等。
 * 
 * 包含两大核心优化：
 * 1. 路径压缩 (Path Compression): 使树的高度尽可能矮。
 * 2. 按秩合并 (Union by Rank/Size): 保证小树合并到大树，防止树退化成链表。
 */
public class Solution {

    /**
     * LeetCode 547. 省份数量 (原朋友圈问题)
     * 有 n 个城市，其中一些彼此相连，另一些则不相连。如果城市 a 与城市 b 直接相连，
     * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 
     * @param isConnected 邻接矩阵，isConnected[i][j] = 1 表示 i 和 j 直接相连
     * @return 省份的数量
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getCount();
    }

    /**
     * 并查集标准模板类
     */
    class UnionFind {
        private int[] parent; // 记录每个节点的父节点
        private int[] rank;   // 记录树的高度（秩），用于按秩合并
        private int count;    // 记录连通分量的个数

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 初始时，每个节点的父节点是它自己
                rank[i] = 1;   // 初始高度为 1
            }
        }

        /**
         * 查找操作 (Find): 寻找元素所在的根节点
         * 包含路径压缩优化 (Path Compression)
         */
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            // 递归查找并将 i 的父节点直接指向根节点，从而压扁整棵树
            return parent[i] = find(parent[i]);
        }

        /**
         * 合并操作 (Union): 将两个元素所属的集合合并
         * 包含按秩合并优化 (Union by Rank)
         */
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            
            if (rootI != rootJ) {
                // 将高度较小的树合并到高度较大的树上
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootI] = rootJ;
                    rank[rootJ]++; // 只有高度相同时，合并后高度才会增加
                }
                count--; // 每次成功合并，连通分量数量减 1
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // 测试用例 1: 1,2 相连，3 独立 -> 2 个省份
        int[][] test1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Test Case 1: " + sol.findCircleNum(test1)); // 期待输出: 2

        // 测试用例 2: 全部独立 -> 3 个省份
        int[][] test2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Test Case 2: " + sol.findCircleNum(test2)); // 期待输出: 3
    }
}

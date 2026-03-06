package dp;

import java.util.*;

/**
 * 72. 编辑距离 (Edit Distance)
 * 经典动态规划题目：计算从 word1 转换成 word2 所需的最少操作数。
 * 允许的操作：插入一个字符、删除一个字符、替换一个字符。
 * 
 * 核心思路：
 * 1. dp[i][j]：word1 的前 i 个字符转换成 word2 的前 j 个字符的最少操作数。
 * 2. 状态转移：
 *    - 若 word1[i-1] == word2[j-1]，则 dp[i][j] = dp[i-1][j-1]
 *    - 否则，dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
 */
public class Solution8 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] 表示 word1[0...i-1] 到 word2[0...j-1] 的距离
        int[][] dp = new int[m + 1][n + 1];

        // 边界处理：空字符串转换成长度为 i/j 的字符串所需的步数
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 字符相同，不需要额外操作
                } else {
                    // 1 + min(删除, 插入, 替换)
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        
        // 示例 1: 
        String w1 = "horse", w2 = "ros";
        System.out.println("测试 1: \"" + w1 + "\" -> \"" + w2 + "\"");
        System.out.println("结果: " + sol.minDistance(w1, w2)); // 预期: 3 (h->r, r删, e删)

        // 示例 2:
        String w3 = "intention", w4 = "execution";
        System.out.println("测试 2: \"" + w3 + "\" -> \"" + w4 + "\"");
        System.out.println("结果: " + sol.minDistance(w3, w4)); // 预期: 5
    }
}

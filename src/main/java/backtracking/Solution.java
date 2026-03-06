package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 经典 N 皇后问题 (默认 8 皇后)
 * 使用回溯算法求解所有可能的解
 */
public class Solution {

    /**
     * 解决 N 皇后问题
     * @param n 棋盘大小
     * @return 所有解的列表，每个解用 "." 和 "Q" 表示
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // 标记列、主对角线、副对角线是否有皇后，用于快速剪枝
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // 主对角线: row - col (偏移 n-1)
        boolean[] diag2 = new boolean[2 * n - 1]; // 副对角线: row + col

        backtrack(results, board, 0, n, cols, diag1, diag2);
        return results;
    }

    private void backtrack(List<List<String>> results, char[][] board, int row, int n,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // 找到一个解
        if (row == n) {
            results.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;
            
            // 如果当前位置在列、主对角线或副对角线上已存在皇后，则跳过
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // 放置皇后并标记
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // 递归处理下一行
            backtrack(results, board, row + 1, n, cols, diag1, diag2);

            // 回溯：撤销放置与标记
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 8;
        List<List<String>> results = sol.solveNQueens(n);
        
        System.out.println(n + " 皇后问题的解总数: " + results.size());
        if (!results.isEmpty()) {
            System.out.println("展示其中一个解:");
            for (String row : results.get(0)) {
                System.out.println(row);
            }
        }
    }
}

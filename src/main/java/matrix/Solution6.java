package matrix;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class Solution6 {

    private char[][] board;// 仅仅为了递归少传参数
    private String word;// 仅仅为了递归少传参数

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 每个点都当成【起点】处理，看是否满足。只要有一个满足，就返回 true
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        // 当前的点越界了 or 与给定值不同 or 已经搜索过（特殊处理0），直接 false
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(k)) {
            return false;
        }
        // 检查到最后了。返回 true
        if (k == word.length() - 1) {
            return true;
        }
        char c = board[i][j];// 临时保存，需要恢复
        board[i][j] = 0;// 字符串没有0。它和任何给定的字符都匹配不上。表明当前字符已经搜索过了。杜绝循环递归
        // k+1 即为给定字符串的下一个位置。既然当前相同，则比较下一个是否相同。
        // 上下左右搜索，看下一个字符是否匹配（本方法是递归的。其实是看后续的字符是否全部匹配）
        boolean ret = dfs(i - 1, j, k + 1) || dfs(i, j - 1, k + 1) || dfs(i + 1, j, k + 1) || dfs(i, j + 1, k + 1);// 只要有一个是相同的，即为 true
        board[i][j] = c;// 恢复
        return ret;
    }
}
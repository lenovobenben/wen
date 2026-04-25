package tree;

/**
 * 124. 二叉树中的最大路径和
 */
public class Solution9 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    /**
     * 返回以当前节点为起点，向下延伸的最大路径和
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        int currentPathSum = node.val + left + right;
        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(left, right);
    }
}

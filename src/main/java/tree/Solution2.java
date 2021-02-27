package tree;

/**
 * 110. 平衡二叉树
 *
 * 平衡的定义如下，已知对于树中的任意一个结点，若其两颗子树的高度差不超过1，则我们称该树平衡。
 * 现给定指向树根结点的指针TreeNode* root，请编写函数返回一个bool，表示该二叉树是否平衡。
 */
public class Solution2 {

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <=1 && isBalance(root.left) && isBalance(root.right);
    }

    /**
     * 求树的最大高度（深度）
     */
    public int height (TreeNode node) {
        if (node==null) {
            return 0;
        }
        return Math.max(height(node.left),height(node.right)) + 1;
    }

}

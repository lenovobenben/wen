package tree;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 也叫做：翻转二叉树
 */
public class Solution5 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}

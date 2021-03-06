package tree;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Solution6 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {// 全为空
            return true;
        }
        if (left == null || right == null || left.val != right.val) {// 其中一个为空 或者 值不相同
            return false;
        }

        // 递归调用
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
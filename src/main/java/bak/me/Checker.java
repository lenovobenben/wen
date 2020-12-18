package bak.me;

/**
 * 现给定树的根结点指针TreeNode* root，编辑函数返回一个bool值，判断该树是否为二叉查找树。
 *
 * 此题太难了。。。
 */
public class Checker {
    public boolean checkBST(TreeNode root) {
        return travese(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean travese(TreeNode node, int min, int max) {
        if (node == null)
            return true;
        if (node.val > max || node.val < min)
            return false;
        if (node.left == null && node.right == null)
            return true;
        if (node.left == null && node.val < node.right.val) {
            return travese(node.right, node.val, max);
        } else if (node.right == null && node.val > node.left.val) {
            return travese(node.left, min, node.val);
        } else if (node.left.val < node.val && node.val < node.right.val) {
            return travese(node.left, min, node.val) && travese(node.right, node.val, max);
        } else
            return false;
    }
}

package bak.me;

/**
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 */
public class Solution15 {

    /**
     * 递归
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null) {// 没找到
            return 0;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if (left == 0) {// 左边没有找到，全在右边
            return right;
        } else if (right == 0) {// 右边没有找到，全在左边
            return left;
        }

        // 在两边，当前 root 即为目标值（此时，left/right 分别为 o1/o2 的值，绝不可能出现其它值!）
        return root.val;
    }
}

package tree;

import java.util.HashMap;

/**
 * 236. 二叉树的最近公共祖先
 */
public class Solution4 {

    /**
     * 递归方式
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {// 没找到
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {// 左边没有找到，全在右边
            return right;
        } else if (right == null) {// 右边没有找到，全在左边
            return left;
        }

        // 在两边，当前 root 即为目标值
        return root;
    }


    /**
     * 利用中序遍历
     */
    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        this.iter(root, map);

        TreeNode temp1 = p;
        TreeNode temp2 = q;
        while (true) {
            if (temp1 != temp2) {
                temp1 = map.get(temp1);
                if (temp1 == null) {
                    temp1 = q;
                }
                temp2 = map.get(temp2);
                if (temp2 == null) {
                    temp2 = p;
                }
            } else {
                return temp1;
            }
        }
    }

    public void iter(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        iter(root.left, map);
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        iter(root.right, map);
    }
}
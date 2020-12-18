package bak.me;

/**
 * 给定一棵 二叉搜索树 ，请找出其中的第k小的结点。
 */
public class Solution8 {

    public int i;
    public TreeNode ret = null;

    void iter(TreeNode pRoot, int k) {
        if (ret != null) {
            return;
        }
        if (pRoot != null) {
            iter(pRoot.left, k);
            i++;
            if (i == k) {
                ret = pRoot;
                return;
            }
            iter(pRoot.right, k);
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        this.iter(pRoot, k);
        return this.ret;
    }

    public static void main(String[] args) {
        TreeNode root = Common.getTreeNode();
        Solution8 solution8 = new Solution8();
        solution8.iter(root, 3);
        System.out.println(solution8.ret.val);
    }
}

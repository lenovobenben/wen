package tree;

/**
 * 98. 验证二叉搜索树
 */
public class Solution3 {
    public boolean isValidBST(TreeNode root) {
        this.traversal(root);
        return flag;
    }

    // 保存上一个值
    private Integer last = null;
    private boolean flag = true;

    /**
     * 中序遍历
     * 比较和上一个值的大小关系
     */
    public void traversal(TreeNode node) {
        if (!flag) {// 存在相反的顺序
            return;
        }
        if (node == null) {
            return;
        }
        traversal(node.left);
        if (last!=null && last >= node.val) {// 相反的顺序
            flag = false;
            return;
        }
        last = node.val;
        traversal(node.right);
    }

}
package bak.me;

/**
 * 二叉树 节点的个数
 */
public class TreeNodeNum {
    public int calNum (TreeNode node) {
        if (node==null) {
            return 0;
        } else {
            return calNum(node.left) + calNum(node.right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = Common.getTreeNode();
        System.out.println(new TreeNodeNum().calNum(root));
    }
}

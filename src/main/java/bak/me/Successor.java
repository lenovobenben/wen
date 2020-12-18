package bak.me;

/**
 * 给定树的根结点指针TreeNode* root和结点的值int p，
 * 编写一个函数，寻找该二叉树中指定结点的下一个结点（即中序遍历的后继），并返回p结点的后继结点的值。
 * 保证结点的值是小于等于100000的正数且没有重复值，若不存在后继返回-1。
 */
public class Successor {

    // 返回值。默认 -1
    private int ret = -1;

    // false 未找到 p
    // true 找到了 p
    private boolean status = false;

    public int findSucc(TreeNode root, int p) {
        traversal(root, p);
        return ret;
    }

    // 递归遍历
    public void traversal(TreeNode node, int p) {
        if (node == null || ret != -1) {// 如果 ret 有值了，无需递归
            return;
        }
        traversal(node.left, p);
        if (node.val == p) {// 找到了p
            status = true;
        } else if (ret == -1 && status) {// ret 没设置过，并且找到了 p
            ret = node.val;// 注意：这个 node 不是 p 的那个 node ，而是下一个！！！
            return;// 无需继续递归
        }

        traversal(node.right, p);
    }

    public static void main(String[] args) {
        TreeNode root = Common.getTreeNode();
        System.out.println(new Successor().findSucc(root, 5));
    }
}

package bak.me;

/**
 * 二叉查找树 -> 双向链表
 */
public class Converter2 {

    ListNode2 head;
    ListNode2 last;// 上一个

    public void traversal(TreeNode node) {
        if (node != null) {

            traversal(node.left);

            ListNode2 cur = new ListNode2(node.val);

            if (last != null) {
                last.next = cur;
            }

            cur.prev = last;

            if (head == null) {
                head = cur;
            }

            last = cur;

            traversal(node.right);

        }
    }

    public static void main(String[] args) {
        TreeNode root = Common.getTreeNode();
        Converter2 c = new Converter2();
        c.traversal(root);

        System.out.println(c.head);
    }
}

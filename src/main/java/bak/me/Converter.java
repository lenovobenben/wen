package bak.me;

/**
 *
 * 给定二叉查找树的根结点指针root，现编写一个方法，将二叉查找树转换为链表。
 * 其中二叉查找树的数据结构用TreeNode实现（包含了val属性和指向其它结点的指针），eft指针表示左儿子，right指针表示右儿子。
 * 请返回生成的链表的头指针。
 */
public class Converter {
    private ListNode head = new ListNode(-1);
    private ListNode temp = head;
    public ListNode treeToList(TreeNode root) {
        if(root!=null){
            treeToList(root.left);
            temp.next = new ListNode(root.val);
            temp = temp.next;
            treeToList(root.right);
        }
        return head.next;
    }

    public static void main(String[] args) {
        TreeNode root = Common.getTreeNode();

        Common.print(new Converter().treeToList(root));
    }


}

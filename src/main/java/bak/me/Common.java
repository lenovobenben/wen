package bak.me;

import java.util.Random;

/**
 * 一些公共方法
 */
public class Common {

    /**
     * 打印链表 公用方法
     */
    public static void print(ListNode head) {
        ListNode printCur = head;
        while (true) {
            if (printCur == null) {
                break;
            }
            System.out.print(printCur.val + " ");
            printCur = printCur.next;

        }
        System.out.println();
    }


    private static Random r = new Random();

    /**
     * 生成随机数的链表
     */
    public static ListNode createListNodes() {
        ListNode head = new ListNode();// 定义一个头
        head.val = r.nextInt(100);// 第一个的值特殊处理
        ListNode cur = head;// 游标

        for (int i = 0; i < 20; i++) {
            cur.next = new ListNode();
            cur.next.val = r.nextInt(100);
            cur = cur.next;
        }
        return head;
    }


    /**
     * 构造一棵树
     */
    public static TreeNode getTreeNode() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);

        root.left.left.left.left = new TreeNode(1);

        return root;
    }

    public static ListNode getListNode () {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        return n1;
    }
}

package bak.me;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 */
public class Solution11 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 有可能删除的就是头，因此有必要在前边加一个节点
        ListNode node0 = new ListNode(0);
        node0.next = head;
        ListNode first = node0;
        ListNode second = node0;
        for (int i = 1; i <= n + 1; i++) {// first 移动n+1个
            first = first.next;
        }

        // 同时移动 first second
        while (first != null) {// first 到末尾退出，则 second 是倒数第 n+1 个
            first = first.next;
            second = second.next;
        }

        // 删除 second 的下一个
        second.next = second.next.next;
        return node0.next;
    }

    public static void main(String[] args) {
        new Solution11().removeNthFromEnd(Common.getListNode(), 3);
    }

}

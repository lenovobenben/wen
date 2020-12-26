package linkedList;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 */
public class Solution2 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode node0 = new ListNode(0);// 特殊处理 原来的 head
        node0.next = head;
        ListNode first = node0;
        ListNode second = node0;
        for (int i = 1; i <= n+1; i++) {// first 移动 n+1 个
            first = first.next;
        }
        // 同时移动 first second
        while (first!=null) {// first 到末尾就退出了，此时 second 是倒数第 n+1 个
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;// 删除 second的下一个
        return node0.next;
    }
}

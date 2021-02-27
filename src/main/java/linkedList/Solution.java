package linkedList;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 反转链表
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode nowNode = head;
        ListNode preNode = null;// 正向
        while (nowNode!=null) {
            ListNode nextNode = nowNode.next;// 暂存
            nowNode.next = preNode;
            // 为下一次循环 做准备
            preNode = nowNode;
            nowNode = nextNode;
        }
        return preNode;
    }
}

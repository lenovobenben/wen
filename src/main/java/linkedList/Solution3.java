package linkedList;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 相交链表的第一个交点：两个指针分别以1个元素为步长，向后移动，起点为各自链表的head，
        // 每个指针走到自身链表的尾部，再重新以另一链表的head为起点，向后移动。这样，两个指针相遇的节点即为第一个交点
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = (h1 == null ? headB : h1.next);
            h2 = (h2 == null ? headA : h2.next);
        }
        return h1;
    }
}

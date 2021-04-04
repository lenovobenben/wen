package sort;

import linkedList.ListNode;

/**
 * 148. 排序链表
 * O(n log n) 时间复杂度
 */
class Solution4 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;// 快慢指针用来寻找中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;// 中点的下一个
        slow.next = null;// 打断链表
        ListNode left = sortList(head);// 前半段的 head 依然是 head 。 递归调用
        ListNode right = sortList(tmp);// 后半段的 head 为 tmp 。 递归调用
        ListNode h = new ListNode(0);// 临时 head ，在循环中不停后移
        ListNode res = h;// 第一个元素，它是不变的，不参与排序。它的下一个是真正的 head。
        while (left != null && right != null) {// 两个有序链表合并
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 必有一个链表移动到了末尾！
        h.next = left != null ? left : right;// 把不是 null 的补在 h 后面
        return res.next;// 返回真正的 head
    }
}
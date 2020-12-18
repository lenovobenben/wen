package bak.me;

/**
 * 将两个有序的链表合并为一个新链表，
 * 要求新的链表是通过拼接两个链表的节点来生成的。
 */
public class Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode retHead = null;
        ListNode retTemp = null;
        if (l1.val >= l2.val) {
            retHead = l2;
            retTemp = l2;
            l2 = l2.next;
        } else {
            retHead = l1;
            retTemp = l1;
            l1 = l1.next;
        }

        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                retTemp.next = l2;
                retTemp = retTemp.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                retTemp.next = l1;
                retTemp = retTemp.next;
                l1 = l1.next;
                continue;
            }

            if (l1.val >= l2.val) {
                retTemp.next = l2;
                retTemp = retTemp.next;
                l2 = l2.next;
            } else {
                retTemp.next = l1;
                retTemp = retTemp.next;
                l1 = l1.next;
            }
        }

        return retHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        ListNode ret = new Solution2().mergeTwoLists(l1, l2);
        Common.print(ret);
    }
}

package twoPointers;

import linkedList.ListNode;

/**
 * 判断给定的链表中是否有环
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 初始化两个指针
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast!=null && fast.next!=null && slow!=null) {
                fast = fast.next.next;// 2个
                slow = slow.next;
                if (fast==slow) {
                    return true;
                }
            } else {// 到末尾，无环
                return false;
            }
        }
    }
}
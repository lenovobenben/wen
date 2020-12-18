package bak.me;

/**
 * 判断给定的链表中是否有环
 */
public class Solution {

    /**
     * 用一快一慢指针，
     * 开始两个指针都指向链表头部。慢指针每次向前走一步，快指针每次向前走两步。
     * 如果有环，则两个指针最终一定会相遇。
     * 这种方法无须额外的空间。
     */
    public boolean hasCycle(ListNode head) {
        // 初始化两个指针
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast!=null && fast.next!=null && slow!=null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            } else {// 某个指针已经到末尾了
                return false;
            }
        }
    }
}
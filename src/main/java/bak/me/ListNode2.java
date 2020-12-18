package bak.me;

/**
 * 双向链表
 * prev
 * next
 *
 */
public class ListNode2 {
    public ListNode2 prev;
    public ListNode2 next;
    public Integer val;

    public ListNode2 (){}

    public ListNode2 (int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}

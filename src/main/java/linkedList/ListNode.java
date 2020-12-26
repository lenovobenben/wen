package linkedList;

/**
 * 链表的节点
 */
public class ListNode {
    public ListNode next;
    public Integer val;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " ";
    }

}

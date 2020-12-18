package bak.me;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class Solution9 {

    /**
     * 首先定义两个指向链表头的指针p  ,q;
     * 先令一个指针指向第k节点，然后两个指针同时向后移动，
     * 最后p指向的即为倒数第k个节点。当k为零或节点为空返回。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode front = head;
        ListNode back = null;// 在 front 后第 k 个节点
        int i = 0;
        while (true) {
            if (i == k) {
                back = head;
            }
            if (front == null) {
                break;
            }
            i++;
            front = front.next;
            if (back != null) {
                back = back.next;
            }
        }
        return back;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().FindKthToTail(Common.getListNode(), 5));
    }

}

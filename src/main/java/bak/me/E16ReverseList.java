package bak.me;

/**
 * 反转一个链表
 */
public class E16ReverseList {


    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode preListNode = null;
        ListNode nowListNode = head;

        while (nowListNode != null) {
            ListNode nextListNode = nowListNode.next;   // 暂存下一个结点
            nowListNode.next = preListNode;             // 当前结点指向前一个结点
            preListNode = nowListNode;                  // 前任结点到现任节点
            nowListNode = nextListNode;                 // 现任节点到下一结点
        }
        return preListNode;
    }

    public static void main(String[] args) {
        ListNode head = Common.getListNode();
        E16ReverseList test = new E16ReverseList();

        Common.print(head);

        ListNode result = test.ReverseList(head);

        Common.print(result);
    }

}

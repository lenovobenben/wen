package bak.me;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Solution5 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while (true) {

            if (pHead1 == null && pHead2 == null) {
                return null;
            }

            if (pHead1 != null) {
                if (set.contains(pHead1)) {
                    return pHead1;
                } else {
                    set.add(pHead1);
                    pHead1 = pHead1.next;
                }
            }

            if (pHead2 != null) {
                if (set.contains(pHead2)) {
                    return pHead2;
                } else {
                    set.add(pHead2);
                    pHead2 = pHead2.next;
                }
            }
        }
    }
}

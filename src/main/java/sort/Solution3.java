package sort;

import linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class Solution3 {

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = Comparator.comparing(o -> o.val);
        ListNode head = null;
        ListNode temp = null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(comparator);// 堆，每次取得最小值！
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }
        while (heap.size() > 0) {
            ListNode temp0 = heap.poll();// 弹出最小值
            if (head == null) {// 初始化
                head = temp0;
                temp = head;
            } else {// 指向下一个
                temp.next = temp0;
                temp = temp.next;// 指向下一个，进入下一次循环
            }
            if (temp0.next != null) {// heap 中 扔进去下一个
                heap.offer(temp0.next);// 将此链表的下一个扔进去
            }
        }
        return head;
    }

}
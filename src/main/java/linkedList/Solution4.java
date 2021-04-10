package linkedList;

/**
 * 237. 删除链表中的节点
 */
public class Solution4 {
    public void deleteNode(ListNode pNode) {
        if (pNode.next == null) {// 尾
            return;// 无法删除
        }
        // 把下一个节点的值赋值到该节点上，同时跳过该节点即可
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return;
    }
}

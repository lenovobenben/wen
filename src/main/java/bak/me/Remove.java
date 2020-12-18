package bak.me;

/**
 * 给定一个单向链表中的某个节点，请删除这个节点，但要求只能访问该节点。
 * 若该节点为尾节点，返回false，否则返回true
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {

        if (pNode.next==null) {// 尾
            return false;// 无法删除
        }

        // 把下一个节点的值赋值到该节点上，同时跳过该节点即可
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;
    }
}

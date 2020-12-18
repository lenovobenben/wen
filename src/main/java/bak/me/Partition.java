package bak.me;


/**
 * 现有一链表的头指针 ListNode* pHead，给一定值x。
 * 编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
 */
public class Partition {

    public ListNode partition(ListNode pHead, int x) {

        ListNode little = null;
        ListNode littleCur = null;

        ListNode big = null;
        ListNode bigCur = null;

        ListNode cur = pHead;

        while (true) {

            if (cur == null) {
                break;
            }

            if (cur.val < x) {// 放入 little
                if (little == null) {// 第一个
                    little = cur;
                    littleCur = cur;
                } else {// 非第一个
                    // 上一个的 next 指向 当前
                    littleCur.next = cur;
                    // 重置 游标
                    littleCur = cur;
                }
            } else {// 放入 big
                if (big == null) {// 第一个
                    big = cur;
                    bigCur = cur;
                } else {// 非第一个
                    bigCur.next = cur;
                    bigCur = cur;
                }
            }

            // 重置游标
            cur = cur.next;

        }

        if (littleCur != null) {
            littleCur.next = big;// 将两个链表拼接起来。此时 littleCur 为 little 的最后一个元素
        }

        if (bigCur != null) {
            bigCur.next = null;// 最末尾的指向 null
        }

        ListNode ret = little != null ? little : big;
        return ret;
    }


    public static void main(String[] args) {

        ListNode head = Common.createListNodes();

        // 打印 生成的链表
        Common.print(head);

        System.out.println();

        Common.print(new Partition().partition(head, 40));

        System.out.println();

    }




}

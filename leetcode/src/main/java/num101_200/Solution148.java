package num101_200;

import helper.ListNode;

/**
 * 148. 排序链表
 */
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return mergeSort(head);
    }

    /**
     * 递归进行归并排序
     * @param head
     * @return
     */
    private ListNode mergeSort(ListNode head) {
        if (head.next == null ) {
            return head;
        }

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        // 快慢指针查找链表中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode q = slow.next;
        // 截断链表
        slow.next = null;
        // 递归进行归并排序
        ListNode p = mergeSort(head);
        q = mergeSort(q);
        // 对排序号的链表进行归并
        head = merge(p, q);
        return head;
    }

    /**
     * 归并
     * @param p
     * @param q
     * @return
     */
    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (p != null || q != null) {
            if (p == null) {
                cur.next = q;
                q = q.next;
            } else if (q == null) {
                cur.next = p;
                p = p.next;
            } else {
               if (p.val < q.val) {
                   cur.next = p;
                   p = p.next;
               } else {
                   cur.next = q;
                   q = q.next;
               }

            }

            cur = cur.next;
        }

        return dummyHead.next;
    }
}
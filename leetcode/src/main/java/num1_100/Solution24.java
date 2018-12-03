package num1_100;

import helper.ListNode;

/**
 * 24. 两两交换链表中的节点
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        // 每次cur和next交换位置
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null && next != null) {

            // 交换cur 和next
            cur.next = next.next;
            next.next = cur;
            pre.next = next;

            // 移动pre, cur, next
            pre = cur;
            cur = cur.next;
            if (cur == null){
                break;
            }
            next = cur.next;
        }

        return dummyHead.next;

    }
}
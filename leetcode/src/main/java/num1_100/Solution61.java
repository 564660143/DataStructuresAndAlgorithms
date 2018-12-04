package num1_100;

import helper.ListNode;

/**
 * 61. 旋转链表
 */
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length ++;
        }

        k = k % length;
        if(k == 0) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first != null){
            if (first.next == null){
                break;
            }
            first = first.next;
            second = second.next;
        }

        ListNode newHead = second.next;
        second.next = null;
        first.next = head;

        return newHead;
    }
}
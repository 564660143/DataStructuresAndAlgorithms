package num1_100;

import helper.ListNode;

/**
 * 25. k个一组翻转链表
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        return reverse(head, k);
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        // 校验是否可以翻转
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            } else {
                cur = cur.next;
            }
        }

        // 下一组要考察的头节点
        ListNode nextReverse = cur;
        ListNode pre = null;
        cur = head;
        ListNode next;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 递归进行翻转
        head.next = reverse(nextReverse, k);
        // pre为翻转后的头结点
        return pre;
    }
}
package num1_100;

import helper.ListNode;

/**
 * 23. 合并K个排序链表
 */
class Solution23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list : lists) {
            result = merge(result, list);
        }
        return result;
    }

    /**
     * 合并两个链表, 返回合并之后的头结点
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                return dummyHead.next;
            }
            if (l2 == null) {
                cur.next = l1;
                return dummyHead.next;
            }
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
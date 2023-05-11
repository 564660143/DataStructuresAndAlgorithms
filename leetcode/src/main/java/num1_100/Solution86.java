package num1_100;

import helper.ListNode;

/**
 * 86. 分隔链表
 */
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        // 小于x的链表
        ListNode dummyHead1 = new ListNode(0);
        // 大于等于x的链表
        ListNode dummyHead2 = new ListNode(0);
        dummyHead1.next = head;
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null){
            if (head.val >= x) {
                // 将大于等于x的节点放入链表dummyHead2中
                node2.next = head;
                node2 = node2.next;
            } else {
                node1.next = head;
                node1 = node1.next;
            }
            head = head.next;
        }

        node1.next = dummyHead2.next;
        node2.next = null;
        return dummyHead1.next;
    }
}
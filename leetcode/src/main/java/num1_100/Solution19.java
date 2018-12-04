package num1_100;

import helper.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for (int i = 0; i <= n; i++) {
            if (second == null) {
                throw  new IllegalArgumentException("输入的参数n不合法");
            }
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        // 执行删除操作
        first.next = first.next.next;

        return dummyHead.next;
    }
}
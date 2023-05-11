package num201_300;

import helper.ListNode;

/**
 * 203. 移除链表元素
 */
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val) {
                // 删除元素
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

}
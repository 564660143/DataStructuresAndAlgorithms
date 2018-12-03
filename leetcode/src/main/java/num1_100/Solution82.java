package num1_100;

import helper.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        // 标识当前节点是否需要删除
        boolean curIsDelete = false;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                // 出现重复节点, 将当前cur标记为需要删除
                curIsDelete = true;
            } else {
                if (curIsDelete) {
                    pre.next = cur.next;
                    cur = pre.next;
                    // 新的cur节点,所以需要重置curIsDelete
                    curIsDelete = false;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }

        if (curIsDelete) {
            pre.next = cur.next;
            cur = pre.next;
            // 新的cur节点,所以需要重置curIsDelete
            curIsDelete = false;
        }

        return dummyHead.next;
    }
}
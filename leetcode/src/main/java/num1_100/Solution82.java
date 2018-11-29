package num1_100;

import helper.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 也可以使用一个HashSet来判断是否是重复元素, 这样实现起来可能更简单一点
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设定虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 标记是否为重复元素
        boolean isDuplicate = false;
        ListNode pre = dummyHead, cur = head, next = head.next;
        while (cur != null && next != null){
            if (cur.val == next.val){
                // 删除next节点
                cur.next = next.next;
                next.next = null;
                next = cur.next;
                // 将isDuplicate标记为true
                isDuplicate = true;
            } else {
                if (isDuplicate) {
                    // 删除当前节点
                    pre.next = cur.next;
                    cur.next = null;
                    cur = next;
                    next = next.next;
                    isDuplicate = false;
                } else {
                    pre = cur;
                    cur = next;
                    next = next.next;
                }
            }
        }
        // 最后再判断一次
        if (isDuplicate) {
            // 删除当前节点
            pre.next = cur.next;
            cur.next = null;
        }
        return dummyHead.next;
    }
}
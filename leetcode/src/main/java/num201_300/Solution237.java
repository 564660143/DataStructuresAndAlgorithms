package num201_300;

import helper.ListNode;

/**
 * 237. 删除链表中的节点
 */
class Solution237 {
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
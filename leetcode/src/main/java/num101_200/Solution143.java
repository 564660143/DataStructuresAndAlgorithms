package num101_200;

import helper.ListNode;

/**
 * 143. 重排链表
 */
class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表从中间拆成两段, 并对后半部分节点进行翻转
        ListNode secondHead = reverse(slow.next);
        slow.next = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = secondHead;
            if (secondHead != null) {
                secondHead = secondHead.next;
            } else {
                break;
            }
            cur.next.next = next;
            cur = next;
        }

    }

    /**
     * 翻转链表
     * @return
     */
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 遍历到最后,cur和next都为空, 原来的尾节点即新的头结点为pre所指向的节点
        return pre;
    }

}
package num201_300;

import helper.ListNode;

/**
 * 234. 回文链表
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head, cur = head;
        // 快慢指针找出中间点
        while (cur != null && cur.next != null){
            cur = cur.next.next;
            middle = middle.next;
        }
        // 翻转后半部分链表
        ListNode lastHead = reverse(middle);
        while (lastHead != null && head != null){
            if (lastHead.val != head.val){
                return false;
            } else {
                lastHead = lastHead.next;
                head = head.next;
            }
        }

        return true;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
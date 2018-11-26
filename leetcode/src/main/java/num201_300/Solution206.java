package num201_300;

/**
 * 206. 反转链表
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
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

    /**
     * 不加编译报错, LeetCode提交时, 这部分代码可以省略
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}



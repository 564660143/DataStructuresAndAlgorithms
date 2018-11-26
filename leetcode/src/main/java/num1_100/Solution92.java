package num1_100;


/**
 * 92. 反转链表 II
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode mPre = dummyHead;

        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }


        ListNode cur = mPre.next;
        ListNode next = cur.next;
        ListNode nNext = next;
        for (int i = 0; i < n - m; i++) {
            // 执行反转
            nNext = next.next;
            next.next = cur;

            // 移动cur
            cur = next;
            next = nNext;
        }


        mPre.next.next = nNext;
        mPre.next = cur;

        return dummyHead.next;
    }

    /**
     * 不加编译报错, LeetCode提交时, 这部分代码可以省略
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
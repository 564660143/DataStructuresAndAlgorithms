package num101_200;

import helper.ListNode;

/**
 * 147. 对链表进行插入排序
 */
class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // head~pre是排好序的部分
        ListNode pre = head;
        // 第一个元素默认是有序的
        ListNode cur = head.next;
        while (cur != null) {
            // 寻找插入位置
            ListNode insertPre = findInsertIndexPre(dummyHead, cur);
            // 这种情况表示当前节点不需要换位置
            if (insertPre == pre) {
                pre = cur;
                cur = cur.next;
            } else {
                // cur的需要插入到insertPre后面的位置
                pre.next = cur.next;
                cur.next = insertPre.next;
                insertPre.next = cur;

                // 移动cur
                cur = pre.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 查找cur要插入位置的前一个节点
     * @param head
     * @param cur
     * @return
     */
    private ListNode findInsertIndexPre(ListNode head, ListNode cur ){
        while (head.next != cur) {
            if (head.next.val >= cur.val) {
                return head;
            }
            head = head.next;
        }
        return head;
    }
}
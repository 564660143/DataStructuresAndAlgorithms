package num301_400;

import helper.ListNode;

/**
 * 328. 奇偶链表
 */
class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode curOdd = oddHead;
        ListNode curEven = evenHead;
        // 当前节点是否为奇数节点
        boolean isOdd = true;
        while (head != null){
            if (isOdd){
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }


        curEven.next = null;
        curOdd.next = evenHead.next;
        return oddHead.next;
    }
}
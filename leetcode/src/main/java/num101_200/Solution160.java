package num101_200;

import helper.ListNode;

/**
 * 160. 相交链表
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        ListNode curA = headA;
        while (curA != null){
            lengthA++;
            curA = curA.next;
        }
        int lengthB = 0;
        ListNode curB = headB;
        while (curB != null){
            lengthB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                curA = curA.next;
            }
        } else if (lengthA < lengthB) {
            curB = curB.next;
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return  curA;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        return null;
    }
}
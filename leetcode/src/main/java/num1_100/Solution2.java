package num1_100;

import helper.ListNode;

/**
 * 2. 两数相加
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode list1 = l1, list2 = l2, cur = dummyHead;
        // 用于表示进位
        int carry = 0;
        int sum = 0;
        while (list1 != null || list2 != null ){
            sum = carry;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return dummyHead.next;
    }


}
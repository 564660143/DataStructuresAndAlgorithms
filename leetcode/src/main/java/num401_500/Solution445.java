package num401_500;

import helper.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II
 */
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = linkedListToStack(l1);
        Stack<Integer> s2 = linkedListToStack(l2);
        Stack<Integer> result = new Stack<>();
        int num1, num2;
        int sum = 0;
        int carry = 0;
        while ((!s1.isEmpty()) || (!s2.isEmpty())){
            if (!s1.isEmpty()){
                num1 = s1.pop();
            } else {
                num1 = 0;
            }
            if (!s2.isEmpty()){
                num2 = s2.pop();
            } else {
                num2 = 0;
            }
            sum = num1 + num2 + carry;
            carry = sum / 10;
            result.push(sum % 10);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // 处理最后的进位
        if (carry == 1) {
            result.push(carry);
        }

        while (!result.isEmpty()) {
            cur.next = new ListNode(result.pop());
            cur = cur.next;
        }

        return dummyHead.next;
    }

    private Stack<Integer> linkedListToStack(ListNode head){
        Stack<Integer> stack = new Stack();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}
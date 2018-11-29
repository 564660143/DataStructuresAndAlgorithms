package num401_500;

import helper.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II
 */
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> result = new Stack<>();
        // l1元素放入栈中
        while (l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        // l2元素放入栈中
        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        // 进位
        int carry = 0;
        int num1 = 0, num2 = 0;
        int sum;
        while ((!stack1.isEmpty()) || (!stack2.isEmpty())) {
            if (stack1.isEmpty()){
                num1 = 0;
            } else {
                num1 = stack1.pop().val;
            }
            if (stack2.isEmpty()){
                num2 = 0;
            } else {
                num2 = stack2.pop().val;
            }
            sum = num1 + num2 + carry;
            carry = sum / 10;
            result.push(new ListNode(sum % 10));
        }

        // 判断是否最后一次是否有进位
        if(carry == 1){
            result.push(new ListNode(1));
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!result.isEmpty()){
            cur.next = result.pop();
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
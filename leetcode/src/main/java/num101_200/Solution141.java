package num101_200;

import helper.ListNode;

/**
 * 141. 环形链表
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 快慢指针, 如果快慢指针再次碰撞说明有环
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            // 先移动再比较是为了跳过head节点
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
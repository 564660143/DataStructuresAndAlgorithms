package num801_900;

import helper.ListNode;

/**
 * 876. 链表的中间结点
 * 快慢指针
 */
class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head, middle = head;
        while(cur != null){
            if(cur.next != null){
                cur = cur.next.next;
                middle = middle.next;
            } else {
                cur = null;
            }
            
            
        }
        return middle;
    }
}
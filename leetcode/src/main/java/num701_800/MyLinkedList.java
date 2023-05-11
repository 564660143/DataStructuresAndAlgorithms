package num701_800;



class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
            return getNode(index).val;
    }

    private ListNode getNode(int index) {
        if (index >= size) {
            return new ListNode(-1);
        } else {
            ListNode retNode = head;
            for (int i = 0; i < index - 1; i++) {
                retNode = retNode.next;
            }
            return retNode;
        }

    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode first = head;
        head = new ListNode(val);
        if (first == null) {
            tail = head;
        } else {
            head.next = first.next;
            first.prev = head;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode last = tail;
        tail = new ListNode(val);
        if (last == null) {
            head = tail;
        } else {
            tail.prev = last;
            last.next = tail;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }

        if (index < size){
            ListNode beforeNode = getNode(index - 1);
            ListNode addNode = new ListNode(val);
            addNode.next = beforeNode.next;
            addNode.prev = beforeNode;
            beforeNode.next = addNode;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size < 1){
            return;
        }
        if (index == 0){
            ListNode removeNode = head;
            head = head.next;
            head.prev = null;
            removeNode.next = null;
            size--;
            return;
        }
        if (index == size){
            ListNode removeNode = tail;
            tail = tail.prev;
            removeNode.prev = null;
            tail.next = null;
            size--;
            return;
        }

        if (index < size){
            ListNode beforeNode = getNode(index - 1);
            ListNode removeNode = beforeNode.next;
            beforeNode.next = removeNode.next;
            if (removeNode.next != null) {
                removeNode.next.prev = beforeNode;
            }
            removeNode.next = null;
            removeNode.prev = null;
            size--;
        }
    }

    class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int x) {
            val = x;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
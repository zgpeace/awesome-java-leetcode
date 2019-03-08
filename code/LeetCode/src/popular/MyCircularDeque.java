package popular;


class DoubleLinkNode {
    public DoubleLinkNode pre;
    public DoubleLinkNode next;
    public int val;
    public DoubleLinkNode(int val) {
        this.val = val;
    }

}

public class MyCircularDeque {
    int size;
    int capacity;
    DoubleLinkNode head;
    DoubleLinkNode tail;

    /** Initialize your data structure here. Set the size the deque to be k. */
    public MyCircularDeque(int k) {
        head = new DoubleLinkNode(-1);
        tail = new DoubleLinkNode(-1);
        head.next = tail;
        tail.pre = head;

        // 下面两句代码，实际是构成循环列表。但是加不加，LeetCode都可以通过。
        head.pre = tail;
        tail.next = head;

        size = 0;
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        DoubleLinkNode node = new DoubleLinkNode(value);
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

        size++;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        DoubleLinkNode node = new DoubleLinkNode(value);
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;

        size++;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head.next.next.pre = head;
        head.next = head.next.next;

        size--;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;

        size--;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.next.val;
    }

    /** Get the last item from the deque */
    public int getRear() {

        return tail.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        /** Your MyCircularDeque object will be instantiated and called as such: */
        //["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
        //[[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
        int k = 1000;
        MyCircularDeque obj = new MyCircularDeque(k);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(20);
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();

    }

}






































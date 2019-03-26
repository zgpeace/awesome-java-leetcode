package popular;

import common.ListNode;


public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        ListNode previous = null;
        while (head != null) {
            previous = current;
            current = new ListNode(head.val);
            current.next = previous;
            head = head.next;
        }

        return current;
    }

    public ListNode reverseListWithoutChangeHead(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public ListNode reverseListWithRecursive(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = ListNode.listNodeWithIntArray(input);
        System.out.println("Input: " + head.toString());
        ReverseLinkedList obj = new ReverseLinkedList();
        //ListNode result = obj.reverseList(head);
        //ListNode result = obj.reverseListWithoutChangeHead(head);
        ListNode result = obj.reverseListWithRecursive(head);
        System.out.println("Output: " + result.toString());
    }

}

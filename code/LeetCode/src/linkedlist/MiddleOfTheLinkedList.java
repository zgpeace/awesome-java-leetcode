package linkedlist;

import common.ListNode;

public class MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    int[] intArray = {1, 2, 3, 4, 5};
    ListNode head = ListNode.listNodeWithIntArray(intArray);
    MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
    ListNode middleNode = obj.middleNode(head);
    System.out.println(middleNode.toString());
  }
}

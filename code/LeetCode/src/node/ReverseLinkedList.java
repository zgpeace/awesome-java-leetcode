package node;

import common.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    ListNode node = head;
    ListNode pre = null;
    ListNode next;
    while (node != null) {
      next = node.next;
      node.next = pre;
      pre = node;
      node = next;
    }

    return pre;
  }

  public ListNode reverseListWithRecursive(ListNode head) {
    return helperReverseListWithRecursive(head, null);
  }

  private ListNode helperReverseListWithRecursive(ListNode current, ListNode pre) {
    // terminate condition
    if (current == null) {
      return pre;
    }
    ListNode next = current.next;
    current.next = pre;
    pre = current;
    current = next;
    return helperReverseListWithRecursive(current, pre);
  }

  // reverse direct: node.next.next = node
  public ListNode reverseListWithRecursiveTricky(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseListWithRecursiveTricky(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}

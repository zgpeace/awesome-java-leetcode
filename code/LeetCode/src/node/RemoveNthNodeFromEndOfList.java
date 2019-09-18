package node;

import common.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {

  public static void main(String[] args) {
    RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
    int[] intArray = {1, 2, 3, 4, 5};
    ListNode node = ListNode.listNodeWithIntArray(intArray);
    obj.removeNthFromEnd(node, 2);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = new ListNode(0);
    slow.next = head;
    ListNode slowHead = slow;
    ListNode fast = slow;
    // add one more head Node, so need one step forward
    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;

    return slowHead.next;
  }
}

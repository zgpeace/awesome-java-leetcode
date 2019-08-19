package node;

import common.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
  public ListNode addTwoNumbersWithTidyStyle(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    int carry = 0;
    int sum;
    while (l1 != null || l2 != null) {
      sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
      current.next = new ListNode(sum % 10);
      carry = sum / 10;
      l1 = l1 != null ? l1.next : l1;
      l2 = l2 != null ? l2.next : l2;
      current = current.next;
    }
    if (carry == 1) {
      current.next = new ListNode(1);
    }

    return dummyHead.next;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode result = head;
    int carry = 0;
    int sum;
    // sum for every two Node's value, mark carry
    while (l1 != null && l2 != null) {
      sum = l1.val + l2.val + carry;
      head.next = new ListNode(sum % 10);
      carry = sum / 10;
      l1 = l1.next;
      l2 = l2.next;
      head = head.next;
    }

    // add carry for left item
    ListNode leftListNode = l1 != null ? l1 : l2;
    while (leftListNode != null) {
      if (carry == 0) {
        head.next = leftListNode;
        break;
      }
      sum = leftListNode.val + carry;
      head.next = new ListNode(sum % 10);
      carry = sum / 10;
      leftListNode = leftListNode.next;
      head = head.next;
    }

    // consider the last item still have carry, add new one
    if (carry == 1) {
      head.next = new ListNode(1);
      head = head.next;
    }

    return result.next;
  }
}

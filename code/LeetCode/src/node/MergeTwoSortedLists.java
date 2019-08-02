package node;

import common.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode list = new ListNode(0);
    ListNode head = list;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        list.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        list.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      list = list.next;

    }

    while (l1 != null) {
      list.next = new ListNode(l1.val);
      list = list.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      list.next = new ListNode(l2.val);
      list = list.next;
      l2 = l2.next;
    }

    return head.next;
  }


  public ListNode mergeTwoListsWithRecursive(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoListsWithRecursive(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListsWithRecursive(l1, l2.next);
      return l2;
    }
  }

}

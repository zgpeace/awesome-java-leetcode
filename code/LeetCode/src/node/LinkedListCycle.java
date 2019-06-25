package node;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    do {
      if (fast == null || fast.next == null) {
        return false;
      }
      fast = fast.next.next;
      slow = slow.next;
    } while (fast != slow);

    return true;
  }

  public boolean hasCycleWithSet(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) {
        return true;
      }
      set.add(head);
      head = head.next;
    }

    return false;
  }
}

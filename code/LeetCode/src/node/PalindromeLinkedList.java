package node;

import common.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    ListNode l1 = head;
    Stack<Integer> stack = new Stack<>();
    while (l1 != null) {
      stack.push(l1.val);
      l1 = l1.next;
    }

    ListNode l2 = head;
    int c;
    int half = stack.size() >> 1;
    int count = 0;
    while (l2 != null && count < half) {
      c = stack.pop();
      if (c != l2.val) {
        return false;
      }
      l2 = l2.next;
      count++;
    }

    return true;
  }

  public boolean isPalindromeWithSlowFastStep(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      slow = slow.next;
    }
    fast = head;
    slow = reverse(slow);
    while (slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }

  private ListNode reverse(ListNode slow) {
    ListNode pre = null;
    ListNode next;
    while (slow != null) {
      next = slow.next;
      slow.next = pre;
      pre = slow;
      slow = next;
    }

    return pre;
  }

}

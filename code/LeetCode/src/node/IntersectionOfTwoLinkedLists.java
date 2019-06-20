package node;

import common.ListNode;

//  https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {

  public static ListNode getIntersectionNodeWithLoopOtherHead(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;

    ListNode a = headA;
    ListNode b = headB;

    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
      //for the end of first iteration, we just reset the pointer to the head of another linkedlist
      a = a == null? headB : a.next;
      b = b == null? headA : b.next;
    }

    return a;
  }

  public static ListNode getIntersectionNodeWithClipToSameLength(ListNode headA, ListNode headB) {
    int lenA = getNodeLength(headA);
    int lenB = getNodeLength(headB);
    while (lenA > lenB) {
      lenA--;
      headA = headA.next;
    }
    while (lenB > lenA) {
      lenB--;
      headB = headB.next;
    }
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }

  public static int getNodeLength(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }

    return len;
  }

}

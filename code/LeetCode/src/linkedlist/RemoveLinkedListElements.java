package linkedlist;

// https://leetcode.com/problems/remove-linked-list-elements/


import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveLinkedListElements {

  public ListNode removeElements(ListNode head, int val) {
    ListNode result = head;
    ListNode preNode = null;
    boolean isFirstNode = true;
    while (head != null) {
      // the first one
      if (isFirstNode == true) {
        if (head.val == val) {
          // if the first one equal to the remove value, then the element still first
          head = head.next;
          result = head;
        } else {
          isFirstNode = false;
          preNode = head;
          head = head.next;
        }

        continue;
      }

      // middle section
      if (head.val == val) {
        preNode.next = head.next;
        head = head.next;
      } else {
        preNode = head;
        head = head.next;
      }

      // the last one, the same as middle section

    }

    return result;
  }

  public ListNode removeElementsWithRecursive(ListNode head, int val) {
    // exit condition
    if (head == null) return null;
    // recursive from tail to head.
    head.next = removeElementsWithRecursive(head.next, val);
    return head.val == val ? head.next : head;
  }

  public ListNode removeElementWithFakeHead(ListNode head, int val) {
    ListNode fakeHead = new ListNode(-1);
    fakeHead.next = head;
    ListNode pre = fakeHead;
    while (head != null) {
      if (head.val == val) {
        pre.next = head.next;
      } else {
        pre = head;
      }

      head = head.next;
    }

    return fakeHead.next;
  }

  public static void main(String[] args) {
    RemoveLinkedListElements obj = new RemoveLinkedListElements();
    int[] originArray = {1, 2, 6, 3, 4, 5, 6};
    ListNode head = ListNode.listNodeWithIntArray(originArray);
    System.out.println(head.toString());
    //ListNode result = obj.removeElements(head, 6);
    //ListNode result = obj.removeElementsWithRecursive(head, 6);
    ListNode result = obj.removeElementWithFakeHead(head, 6);
    System.out.println(result.toString());

  }

}

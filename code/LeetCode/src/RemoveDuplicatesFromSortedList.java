
public class RemoveDuplicatesFromSortedList {
    /*
    Remove Duplicates from Sorted List
    Description
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2
    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3
    Tags: Linked List
     */

    /*
    思路
    题意是删除链表中重复的元素，很简单，我们只需要遍历一遍链表，
    遇到链表中相邻元素相同时，把当前指针指向下下个元素即可。
     */

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            ListNode temp = this;
            String valString = "";
            while (temp != null) {
                valString = valString + temp.val + "->";
                temp = temp.next;
            }

            return valString;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        int[] inputArray1 = {1, 1, 2};
        ListNode inputListNode1 = buildListNode(inputArray1);
        System.out.println("input: " + inputListNode1.toString());
        System.out.println("output: " + deleteDuplicates(inputListNode1).toString());

        int[] inputArray2 = {1, 1, 2, 3, 3};
        ListNode inputListNode2 = buildListNode(inputArray2);
        System.out.println("input: " + inputListNode2.toString());
        System.out.println("output: " + deleteDuplicates(inputListNode2).toString());
    }

    public  static ListNode buildListNode(int[] intArray) {
        ListNode headL1 = new ListNode(0);
        ListNode l1 = headL1;
        for (int i = 0; i < intArray.length; i++) {
            ListNode newNode = new ListNode(intArray[i]);
            l1.next = newNode;
            l1 = l1.next;
        }

        return headL1.next;
    }


























}

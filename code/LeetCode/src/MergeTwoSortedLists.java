import java.util.List;

public class MergeTwoSortedLists {
    /*
    Merge Two Sorted Lists
    Description
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    Tags: Linked List
     */

    /*
    思路
    题意是用一个新链表来合并两个已排序的链表，那我们只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，
    依次比较下去，最后，当其中一个链表到达了末尾，我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。
     */

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String data = "";
            ListNode temp = this;
            while (temp != null) {
                data = data + temp.val + " ";
                temp = temp.next;
            }
            return data;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        temp.next = l1 != null ? l1 : l2;

        return head.next;
    }

    public static void main(String[] args) {
        int[] inputList1 = {1, 2, 4};
        int[] inputList2 = {1, 3, 4};
        ListNode l1 = buildListNode(inputList1);
        ListNode l2 = buildListNode(inputList2);
        System.out.println("l1: " + l1.toString());
        System.out.println("l2: " + l2.toString());

        ListNode result = mergeTwoLists(l1, l2);
        System.out.println("result: " + result.toString());

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

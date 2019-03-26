import common.ListNode;

public class RemoveNthNodeFromEndOfList {
    /*
    Remove Nth Node From End of List
    Description
    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:

    Given n will always be valid.

    Follow up:

    Could you do this in one pass?

    Tags: Linked List, Two Pointers
     */

    /*
    思路
    题意是让你删除链表中的倒数第 n 个数，我的解法是利用双指针，这两个指针相差 n 个元素，当后面的指针扫到链表末尾的时候，
    自然它前面的那个指针所指向的下一个元素就是要删除的元素，即 pre.next = pre.next.next;，
    但是如果一开始后面的指针指向的为空，此时代表的意思就是要删除第一个元素，即 head = head.next;。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode previousNode = head;
        ListNode afterNode = head;
        while (n-- != 0 && afterNode != null) {
            afterNode = afterNode.next;
        }
        if (afterNode != null) {
            while (afterNode.next != null) {
                previousNode = previousNode.next;
                afterNode = afterNode.next;
            }
            previousNode.next = previousNode.next.next;
        } else {
            head = head.next;
        }

        return head;
    }

//    public static void target(int i) {
//
//    }
//
//    public static void main(String[] args) {
//        Class<?> klass = Class.forName("RemoveNthNodeFromEndOfList");
//        Method method = klass.getMethod("target", int.class);
//        method.equals()
//    }



































}

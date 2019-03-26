import common.ListNode;

public class SwapNodesInPairs {
    /*
    Swap Nodes in Pairs
    Description
    Given a linked list, swap every two adjacent nodes and return its head.

    Example:

    Given 1->2->3->4, you should return the list as 2->1->4->3.
    Note:

    Your algorithm should use only constant extra space.
    You may not modify the values in the list's nodes, only nodes itself may be changed.
    Tags: Linked List
     */

    /*
    思路 0
    题意是让你交换链表中相邻的两个节点，最终返回交换后链表的头，限定你空间复杂度为 O(1)。
    我们可以用递归来算出子集合的结果，递归的终点就是指针指到链表末少于两个元素时，如果不是终点，
    那么我们就对其两节点进行交换，这里我们需要一个临时节点来作为交换桥梁，就不多说了。
     */

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;

        return temp;
    }

    /*
    思路 1
    另一种实现方式就是用循环来实现了，两两交换节点，也需要一个临时节点来作为交换桥梁，
    直到当前指针指到链表末少于两个元素时停止，代码很简单，如下所示。
     */
    public ListNode swapPairsByLoop(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode current = preHead;
        current.next = head;
        while (current.next != null && current.next.next != null) {
            ListNode temp = current.next.next;
            current.next.next = temp.next;
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
        }

        return preHead.next;
    }













































}

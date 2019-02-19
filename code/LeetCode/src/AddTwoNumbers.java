public class AddTwoNumbers {
    /*
    Add Two Numbers
    Description
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
    Tags: Linked List, Math
     */

    /*
    思路
    题意是以链表表示一个数，低位在前，高位在后，所以题中的例子就是 342 + 465 = 807，所以我们模拟计算即可。
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode headNode = resultNode;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int sum = 0;
        while (node1 != null || node2 != null) {
            sum = sum / 10;
            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }
            resultNode.next = new ListNode(sum % 10);
            resultNode = resultNode.next;
        }
        if (sum % 10 != 0) {
            resultNode.next = new ListNode(1);
        }

        return headNode.next;
    }























}

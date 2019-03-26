import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /*
    Merge k Sorted Lists
    Description
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    Example:

    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6
    Tags: Linked List, Divide and Conquer, Heap
     */

    /*
    思路 0
    题意是合并多个已排序的链表，分析并描述其复杂度，我们可以用分治法来两两合并他们，
    假设 k 为总链表个数，N 为总元素个数，那么其时间复杂度为 O(Nlogk)。
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (left + right) >>> 1;
        ListNode l0 = helper(lists, left, mid);
        ListNode l1 = helper(lists, mid + 1, right);

        return merge2ListNode(l0, l1);
    }

    public ListNode merge2ListNode(ListNode nodeFirst, ListNode nodeSecond) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (nodeFirst != null && nodeSecond != null) {
            if (nodeFirst.val < nodeSecond.val) {
                temp.next = new ListNode(nodeFirst.val);
                nodeFirst = nodeFirst.next;
            } else {
                temp.next = new ListNode(nodeSecond.val);
                nodeSecond = nodeSecond.next;
            }

            temp = temp.next;
        }
        temp.next = nodeFirst != null ? nodeFirst : nodeSecond;

        return node.next;
    }

    /*
    思路 1
    还有另一种思路是利用优先队列，该数据结构用到的是堆排序，所以对总链表个数为 k 的复杂度为 logk，
    总元素为个数为 N 的话，其时间复杂度也为 O(Nlogk)。
     */
    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if(o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode node = new ListNode(0);
        ListNode temp = node;
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }

        return node.next;
    }




























































}

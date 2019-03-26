package popular;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<Integer> pastSet = new HashSet<>();
        while (head != null) {
            if (pastSet.contains(head.val)) {
                return true;
            } else {
                pastSet.add(head.val);
                head = head.next;
            }
        }

        return false;
    }

    public boolean hasCycleWithTwoPoint(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != fastNode) {
            if (slowNode == null || fastNode == null || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return true;
    }


}

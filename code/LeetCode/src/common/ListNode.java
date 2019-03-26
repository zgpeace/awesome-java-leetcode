package common;

public class ListNode {
    public int val;
    public  ListNode next;
    public ListNode(int x) {
        val = x;
    }

    static public ListNode listNodeWithIntArray(int[] input) {
        ListNode head = new ListNode(0);
        ListNode node = head;

        for (int i: input) {
            ListNode newNode = new ListNode(i);
            node.next = newNode;
            node = node.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val).append("-->");
            node = node.next;
        }
        return sb.append("Null").toString();
    }
}

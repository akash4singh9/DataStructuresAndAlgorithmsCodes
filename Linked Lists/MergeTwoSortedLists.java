/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode node = new ListNode(0);
        ListNode pointer = node;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                pointer.next = new ListNode(node1.val);
                node1 = node1.next;
                pointer = pointer.next;
            } else {
                pointer.next = new ListNode(node2.val);
                node2 = node2.next;
                pointer = pointer.next;
            }
        }

        while (node1 != null) {
            pointer.next = new ListNode(node1.val);
            node1 = node1.next;
            pointer = pointer.next;

        }

        while (node2 != null) {
            pointer.next = new ListNode(node2.val);
            node2 = node2.next;
            pointer = pointer.next;

        }
        return node.next;
    }
}

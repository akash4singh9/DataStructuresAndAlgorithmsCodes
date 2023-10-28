/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    public Integer lengthOfLinkedList(ListNode n) {
        int pos = 0;
        ListNode node = n;
        while (node != null) {
            node = node.next;
            pos++;
        }
        return pos;
    }

    public ListNode getIntersectionNode(ListNode node1, ListNode node2) {
        int length1 = lengthOfLinkedList(node1);
        int length2 = lengthOfLinkedList(node2);

        ListNode big = (length1 >= length2) ? node1 : node2;
        ListNode small = (length1 >= length2) ? node2 : node1;

        int pos = 0;
        while (pos < Math.abs(length2 - length1)) {
            big = big.next;
            pos++;
        }

        do {
            if (big == small)
                return big;
            big = big.next;
            small = small.next;
        } while (big != null && small != null);
        return null;
    }
}

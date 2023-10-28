/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class DeleteNthNodeFromEnd {

    public int calculateLength(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;

    }

    public ListNode removeNthFromEnd(ListNode head, int B) {
        int position = calculateLength(head) - B + 1;
        if (position <= 1)
            return head.next;

        ListNode node = head;
        while (position > 2) {
            node = node.next;
            position--;
        }
        node.next = node.next.next;
        return head;
    }
}

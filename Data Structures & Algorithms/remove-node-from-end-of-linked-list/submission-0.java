/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        if (length == 1) {
            return null;
        }

        if (n == length) {
            head = head.next;
            return head;
        }

        ListNode prev = head;
        cur = head.next;
        int seen = 1;
        while (seen < length - n) {
            prev = cur;
            cur = cur.next;
            seen++;
        }

        prev.next = cur.next;

        return head;
    }
}

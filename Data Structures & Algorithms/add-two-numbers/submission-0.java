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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        int sum = cur1.val + cur2.val;
        int carry = 0;
        if (sum >= 10) {
            carry = 1;
        }

        ListNode result = new ListNode((int) sum % 10);
        ListNode cur = result;

        cur1 = cur1.next;
        cur2 = cur2.next;
        while (cur1 != null && cur2 != null) {
            sum = cur1.val + cur2.val + carry;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            cur.next = new ListNode((int) sum % 10);
            cur = cur.next;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            sum = cur1.val + carry;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            cur.next = new ListNode((int) sum % 10);
            cur = cur.next;

            cur1 = cur1.next;
        }

        while (cur2 != null) {
            sum = cur2.val + carry;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            cur.next = new ListNode((int) sum % 10);
            cur = cur.next;

            cur2 = cur2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
            carry = 0;
        }

        return result;
    }
}

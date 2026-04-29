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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result, prev, cur;
        result = null;
        prev = null;
        cur = head;


        while (cur != null) {
            ListNode curHead = cur;

            int count = 1;
            for (; count < k; count++) {
                if (cur.next == null) break;

                cur = cur.next;
            }

            if (count < k) {
                if (prev != null) {
                    prev.next = curHead;
                }

                break;
            }

            ListNode next = cur.next;
            cur.next = null;
            cur = next;

            List<ListNode> pointers = reverse(curHead);

            if (result == null) {
                result = pointers.get(0);
            }

            if (prev != null) {
                prev.next = pointers.get(0);
            }

            prev = pointers.get(1);
        }

        return result;
    }

    private List<ListNode> reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev, cur, next, tail;

        prev = null;
        cur = head;
        tail = head;
        next = head.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;

        return List.of(cur, tail);
    }

    private void display(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + ", ");
        }
        System.out.println();
    }
}

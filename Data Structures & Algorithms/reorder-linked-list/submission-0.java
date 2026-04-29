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
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        if (length <= 2) {
            return;
        }

        Stack<ListNode> s = new Stack<>();
        int antiNodes = (int) length / 2;

        int seen = 0;
        cur = head;
        while (seen < length - antiNodes) {
            seen++;
            cur = cur.next;
        }

        while (cur != null) {
            s.push(cur);
            cur = cur.next;
        }

        ListNode next, cur2;

        cur = head;
        ListNode top = s.pop();

        next = cur.next;
        cur.next = top;
        cur2 = top;
        cur = next;

        System.out.println(cur2.val);
        System.out.println(cur.val);
        System.out.println(s.size());
        System.out.println(s.peek().val);

        while (!s.isEmpty()) {
            cur2.next = cur;
            cur2 = cur2.next;
            cur = cur.next;

            cur2.next = s.pop();
            cur2 = cur2.next;
        }

        if (length % 2 != 0) {
            cur2.next = cur;
            cur2 = cur2.next;
            cur = cur.next;
        }

        cur2.next = null;
    }
}

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, cur;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        if (cur1 == null && cur2 == null) {
            return null;
        } else if (cur1 == null) {
            head = cur2;
            cur2 = cur2.next;
        } else {
            head = cur1;
            cur1 = cur1.next;
        }

        cur = head;
        while (cur1 != null && cur2 != null) {
            System.out.println(cur1.val);
            System.out.println(cur2.val);
            
            if (head == null) {
                System.out.println(cur.val);
                System.out.println();
                continue;
            }
            System.out.println(cur.val);
            System.out.println();

            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }

            cur = cur.next;
        }

        while (cur1 != null) {
            cur.next = cur1;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            cur.next = cur2;
            cur2 = cur2.next;
        }

        return head;
    }
}
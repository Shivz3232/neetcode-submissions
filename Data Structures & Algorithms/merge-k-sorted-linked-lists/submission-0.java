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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode cur = head;

        while (true) {
            // display(head);
            // displayMultiple(lists);
            // System.out.println();

            int min = -1;
            
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (min == -1 || lists[i].val < lists[min].val) {
                    min = i;
                }
            }

            if (min == -1) {
                break;
            }

            if (head == null) {
                head = lists[min];
                cur = head;
            } else {
                cur.next = lists[min];
                cur = cur.next;
            }
            
            lists[min] = lists[min].next;
            cur.next = null;
        }

        return head;
    }

    private void displayMultiple(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            display(lists[i]);
        }
    }

    private void display(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + ", ");
        }
        System.out.println();
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node newHead;
        newHead = new Node(head.val);
        Node cur1 = head, cur2 = newHead;

        Map<Node, List<Node>> m = new HashMap<>();

        while (cur1.next != null) {
            if (cur1.random != null) {
                List<Node> l = m.getOrDefault(cur1.random, new ArrayList<>());
                l.add(cur2);
                m.put(cur1.random, l);
            }

            cur1 = cur1.next;

            cur2.next = new Node(cur1.val);
            cur2 = cur2.next;

            if (m.containsKey(cur1)) {
                List<Node> l = m.get(cur1);
                for (Node n : l) {
                    n.random = cur2;
                }
                l.remove(cur1);
            }
        }

        if (cur1.random != null) {
            List<Node> l = m.getOrDefault(cur1.random, new ArrayList<>());
            l.add(cur2);
            m.put(cur1.random, l);
        }

        cur1 = head;
        cur2 = newHead;
        while (cur1 != null) {
            if (m.containsKey(cur1)) {
                List<Node> l = m.get(cur1);
                for (Node n : l) {
                    n.random = cur2;
                }
                l.remove(cur1);
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return newHead;
    }
}

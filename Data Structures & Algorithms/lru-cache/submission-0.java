class LRUCache {
    private final Node head;
    private final Map<Integer, Node> map;
    private Node lru;

    public LRUCache(int capacity) {
        this.head = createLinkedList(capacity);
        this.map = new HashMap<>();
        this.lru = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        
        if (node == lru) {
            progressLruPointer();
        }

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);

        if (node != null) {
            node.val = value;
            if (node == lru) {
                progressLruPointer();
            }
        } else {
            if (lru.key != key) {
                map.remove(lru.key);
            }

            lru.key = key;
            lru.val = value;

            map.put(key, lru);

            progressLruPointer();
        }
    }

    private void progressLruPointer() {
        if (lru.next == null) {
            lru = head;
        } else {
            lru = lru.next;
        }
    }

    private Node createLinkedList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        Node head = new Node();
        Node cur = head;

        for (int i = 1; i < length; i++) {
            cur.next = new Node();
            cur = cur.next;
        }

        return head;
    }

    private void displayLinkedList() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.key + ", " + cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    private class Node {
        public int key = -1;
        public int val = -1;
        public Node next = null;

        public Node() {}
    }
}

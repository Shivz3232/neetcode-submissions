class LRUCache {
    private Node head;
    private Node tail;
    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        initializeDLL(capacity);
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node n = map.getOrDefault(key, head);

        if (n.key == key) {
            n.value = value;
        } else {
            map.remove(n.key);
            
            n.key = key;
            n.value = value;

            map.put(key, n);
        }

        makeNodeMRU(n);

        displayLL();
        System.out.println();
    }

    private void displayLL() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.key + ", " + cur.value);
            cur = cur.next;
        }
    }

    private void makeNodeMRU(Node n) {
        if (n.next == null) {
            return;
        }

        if (n.previous == null) {
            head = head.next;
            head.previous = null;
        } else {
            n.previous.next = n.next;
            n.next.previous = n.previous;
        }

        n.next = null;
        n.previous = tail;

        tail.next = n;
        tail = tail.next;
    }

    private void initializeDLL(int capacity) {
        this.head = new Node();
        this.tail = head;

        for (int i = 1; i < capacity; i++) {
            Node n = new Node();

            tail.next = n;
            n.previous = tail;

            tail = tail.next;
        }
    }

    private class Node {
        public Node next;
        public Node previous;
        public int key;
        public int value;

        public Node() {}
    }
}

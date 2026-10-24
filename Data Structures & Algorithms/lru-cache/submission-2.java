class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addToEnd(Node n) {
        n.prev = tail.prev;
        n.next = tail;
        this.tail.prev.next = n;
        this.tail.prev = n;
    }

    public int get(int key) {
        if(!this.cache.containsKey(key)) {
            return -1;
        }

        Node n = this.cache.get(key);
        this.remove(n);
        this.addToEnd(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.remove(this.cache.get(key));
            this.cache.remove(key);
        }
        
        if(this.cache.size() == capacity) {
            Node first = this.head.next;
            this.remove(first);
            this.cache.remove(first.key);
        }

        Node n = new Node(key, value);
        this.cache.put(key, n);
        this.addToEnd(n);
    }
}

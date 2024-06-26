class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    HashMap<Integer, Node> map = new HashMap();
    Node head = new Node();
    Node tail = new Node();
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            moveToFront(node);
        }
        if (map.size() > this.cap) {
            removeLast();
        }
    }

    private void removeLast() {
        Node node = this.tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.map.remove(node.key);
    }

    private void moveToFront(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        Node headNext = this.head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = this.head;
        this.head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

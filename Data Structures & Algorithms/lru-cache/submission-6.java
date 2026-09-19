class LRUCache {

    private int capacity;
    private int size;
    private Map<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            Node prev = map.get(key);
            remove(prev);
            prev.val = value;
            insert(prev);
            return;
        }

        if(capacity > size){
            map.put(key, node);
            insert(node);
            size++;
            return;
        } else{
            //Remove the leasr recently used node (from the front)
            Node remove = head.next;
            remove(remove);
            map.remove(remove.key);
            insert(node);
            map.put(key, node);
        }
    }

    //Remove the node
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    //Insert from the back
    private void insert(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
}

class Node {
    private int key;
    private int val;
    private Node next;
    private Node prev;
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

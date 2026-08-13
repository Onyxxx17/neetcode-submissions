class LRUCache {

    private Map<Integer,Node> map;
    private int size;
    private int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
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
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.val = value;
            insert(node);
            return;
        }

        Node newNode = new Node(key,value);
        if(size < capacity){
            map.put(key,newNode);
            insert(newNode);
            size++;
        } else{
            //Get LRU
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
            map.put(key,newNode);
            insert(newNode);
        }
    }


    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public void insert(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
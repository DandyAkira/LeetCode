import java.lang.constant.Constable;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    DLinkedNode head = new DLinkedNode();
    DLinkedNode tail = new DLinkedNode();

    public LRUCache(int cap){
        capacity = cap;
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int k, int v){
        if(!this.cache.containsKey(k)){
            DLinkedNode newnode = new DLinkedNode(k,v);
            cache.put(k,newnode);
            newnode.next = this.head.next;
            head.next.prev = newnode;
            head.next = newnode;
            newnode.prev = head;
            size++;
            CheckSize();
        }
        else{
            cache.get(k).value = v;
            cache.get(k).prev.next = cache.get(k).next;
            cache.get(k).next.prev = cache.get(k).prev;
            cache.get(k).next = head.next;
            head.next.prev = cache.get(k);
            head.next = cache.get(k);
            cache.get(k).prev = head;
        }
    }

    private void CheckSize(){
        if(size > capacity){
            cache.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size --;
        }
    }

    public int get(int k){
        if(cache.containsKey(k)){
            cache.get(k).prev.next = cache.get(k).next;
            cache.get(k).next.prev = cache.get(k).prev;
            cache.get(k).next = head.next;
            head.next.prev = cache.get(k);
            head.next = cache.get(k);
            cache.get(k).prev = head;
            return cache.get(k).value;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));;
        lru.get(2);
    }

}

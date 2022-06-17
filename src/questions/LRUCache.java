package questions;
import  java.util.*;

class Node{
    int value;
    int key;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    Node head = new Node(-1, -1);
    Node prev = new Node(-1,-1);

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = prev;
        prev.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            delete(map.get(key));
            insert(map.get(key));
          return map.get(key).value;
        }
            return -1;
    }

    private void insert(Node n){
        Node last = prev.prev;
        Node next = prev;
        last.next = next.prev = n;
        n.next = next;
        n.prev = last;
    }

    private void delete(Node n){
//        n.prev.next = n.next;
//        n.next.prev = n.prev;
        Node prev = n.prev;
        Node  next = n.next;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            map.get(key).value = value;
            delete(map.get(key));
            insert(map.get(key));
        }else{
            Node n = new Node(key,value);
            map.put(key, n);
            insert(n);

            if(map.size() == capacity){
                head = head.next;
                delete(head);
                map.remove(head.key);
            }
        }
    }
}

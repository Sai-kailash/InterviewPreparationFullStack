package Low_Level_Design.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {

    int capacity;
    int size;

    class Node{
        int key, value;
        Node prev;
        Node next;

        Node(){}

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node();
    Node tail = new Node();

    Map<Integer, Node> map;


    LRU_Cache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            insertToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int k, int v){

        if(map.containsKey(k)){
            removeNode(map.get(k));
        } else{
            if(size == capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            } else{
                size++;
            }
        }
        Node node = new Node(k,v);
        insertToHead(node);
        map.put(k, node);

    }

    private void removeNode(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void insertToHead(Node node){

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    public static void main(String[] args){
        LRU_Cache lRUCache = new LRU_Cache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

}

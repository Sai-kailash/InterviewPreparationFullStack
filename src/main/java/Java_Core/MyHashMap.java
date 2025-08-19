package Java_Core;

class Node{
    String key;
    int value;
    Node next;

    Node(String key, int value){
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap {

    Node[] buckets = new Node[100];
    int size = 0;

    private int hashcode(String s){
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash + s.charAt(i);
        }
        return hash%100;
    }

    public int get(String k){

        int hash_code = hashcode(k);
        Node current = buckets[hash_code];

        if(current == null){return -1;}

        while(current != null){
            if(current.key.equals(k)){
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    public void put(String k, int v){

        int hash_code = hashcode(k);
        Node current = buckets[hash_code];

        if(current == null){
            buckets[hash_code] = new Node(k, v);
            size++;
            return;
        }

        while(current.next != null){
            if(current.key.equals(k)){
                current.value = v;
                return;
            }
            current = current.next;
        }

        if(current.key.equals(k)){
            current.value = v;
            return;
        }

        current.next = new Node(k, v);
        size++;
    }

    public void remove(String k){
        int hash_code = hashcode(k);
        Node current = buckets[hash_code];

        if(current == null){
            return;
        }

        if(current.key.equals(k)){
            buckets[hash_code] = (current.next != null)?current.next:null;
            size--;
            return;
        }

        Node prev = current;
        current = current.next;

        while(current != null){
            if(current.key.equals(k)){
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("sai", 1);
        hashMap.put("sbh", 12);
        System.out.println("Size " + hashMap.size);
        System.out.println(hashMap.get("sai"));
        System.out.println(hashMap.get("sbh"));
        hashMap.put("sai", 100);
        System.out.println(hashMap.get("sai"));
        hashMap.put("sai", 300);
        hashMap.remove("sai");
        System.out.println(hashMap.get("sbh"));
        System.out.println("Size " + hashMap.size);
        hashMap.put("sbh", 400);
        System.out.println("Size " + hashMap.size);
    }

}

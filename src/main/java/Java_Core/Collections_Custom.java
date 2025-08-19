package Java_Core;

import java.util.*;

public class Collections_Custom {

    public void printCollections() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1st element");
        arrayList.add("2nd element");
        arrayList.remove(1);

        for (String list : arrayList) {
            System.out.println(list);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.remove(1);
        hashSet.add(2);
        boolean isPresent = hashSet.contains(2);
        hashSet.clear();
        System.out.println("HashSet Is Present " + isPresent);

        Hashtable<Integer, String> table = new Hashtable<>();
        int a = table.hashCode();
        System.out.println("Hash Code " + a);
        table.put(1, "First element");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        boolean contains = linkedList.contains("First");
        linkedList.remove("First");
        linkedList.clear();
        System.out.println("Linked List is present " + contains);

    }

    public static void main(String[] args)  {

        Collections_Custom collectionsCustom = new Collections_Custom();
        collectionsCustom.printCollections();

    }
}

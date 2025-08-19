package Java_Core;

import java.util.*;

class Employee implements Comparable<Employee> {
    private int id;
    public Employee(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id, o.id);
    }
}

// Using Comparable
public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(3));
        empList.add(new Employee(1));
        empList.add(new Employee(2));
        Collections.sort(empList); // Uses natural ordering
        for (Employee e : empList) {
            System.out.println(e.getId());
        }
        int[][] nums = new int[2][2];
        Arrays.sort(nums, (a,b) -> Integer.compare(b[0], a[0]));
    }
}
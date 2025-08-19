package Java_Core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee_Stream {

    public int salary;
    public String name;

    public Employee_Stream(int salary, String name){
        this.name=name;
        this.salary=salary;

    }

    public static void main(String[] args){

        Employee_Stream e1 = new Employee_Stream(40000, "Sai");
        Employee_Stream e2 = new Employee_Stream(50000, "SKBC");
        Employee_Stream e3 = new Employee_Stream(30000, "BC");

        List<Employee_Stream> employeeArrayList = Arrays.asList(e1, e2, e3);

        List<Employee_Stream> employeeStreamlist = employeeArrayList.stream().
                filter(employee -> employee.salary >= 40000)
                .collect(Collectors.toList());

        for(Employee_Stream employee: employeeStreamlist){
            System.out.println(employee.name);
        }
    }
}

package lambdas;/*
 * Sorting class object with lambda expression
 */

import java.util.ArrayList;
import java.util.Collections;

class Employee {
    int no;
    String name;

    Employee(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String toString() {
        return no + ": " + name;
    }

}

public class SortingClassObjects {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        empList.add(new Employee(5, "Samara"));
        empList.add(new Employee(3, "Sarada"));
        empList.add(new Employee(4, "Machetii"));
        empList.add(new Employee(6, "Gimba"));
        empList.add(new Employee(1, "Kaval"));
        empList.add(new Employee(2, "Muerta"));

        System.out.println("Before sorting: " + empList);

        Collections.sort(empList,
                (e1, e2) -> (e1.no < e2.no) ? -1 : (e1.no > e2.no) ? 1 : 0); // Ascen

        System.out.println("After sorting: ");
        System.out.println(empList);
    }
}


package predefine_interfaces.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
* Program to find Total Monthly Salary of All employees by using function
* */
public class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ":" + salary;
    }
}

class TestEmployee {

    static void populate(List<Employee> empList) {
        empList.add(new Employee("Sarman", 23232));
        empList.add(new Employee("Giovan", 2300));
        empList.add(new Employee("Riki", 3232));
        empList.add(new Employee("Joker", 1));
        empList.add(new Employee("Bruce", 999999));
        empList.add(new Employee("Darwin", 10000));
        empList.add(new Employee("Elmon", 34000));
    }

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        populate(empList);

        Function<List<Employee>, Double> f = emp -> {
            double total = 0.0;
            for(Employee employee : empList)
                total += employee.salary;
            return total;
        };

        System.out.println("Total Amount salary of all employees: " + f.apply(empList));

        // Using predicate to increment for employees by using predicate & function
        List<Employee> l = new ArrayList<>();
        populate(l);

        Predicate<Employee> p = emp -> emp.salary < 3500;
        Function<Employee, Employee> f1 = emp -> {
            emp.salary += 488;
            return emp;
        };

        System.out.println("Before Incrementing: ");
        System.out.println(l);

        System.out.println("After increment: ");
        ArrayList<Employee> l2 = new ArrayList<>();
        for(Employee emp : l)
            if(p.test(emp))
                l2.add(f1.apply(emp));

        System.out.println(l);
        System.out.println("Employees with incremented salary: ");
        System.out.println(l2);
    }
}

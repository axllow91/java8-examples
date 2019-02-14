package predefine_interfaces.predicate;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
* Employee Management Application
* */
public class Employee {
    String name;
    String designation;
    double salary;
    String city;

    public Employee(String name, String designation, double salary, String city) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        String s = String.format("[%s, %s,%.2f, %s]", name, designation, salary, city);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp  = (Employee) obj;
        if(name.equals(emp.name) && designation.equals(emp.designation)
                && salary == emp.salary && city.equals(emp.city))
            return true;
        else
            return false;
    }
}

class TestEmployee {

    public static void populate(List<Employee> list) {
        list.add(new Employee("Draka", "CEO", 992390, "San Jose"));
        list.add(new Employee("Samue", "Chief Exec.", 32423, "Buenos Aires"));
        list.add(new Employee("Khabib", "Fighter", 992390, "San Jose"));
        list.add(new Employee("Lka", "Manager", 992390, "San Jose"));
        list.add(new Employee("Kareena","Lead",15000,"Hyderabad"));
        list.add(new Employee("Katrina","Lead",15000,"Bangalore"));
        list.add(new Employee("Anushka","Developer",10000,"Hyderabad"));
        list.add(new Employee("Kanushka","Developer",10000,"Hyderabad"));
        list.add(new Employee("Sowmya","Developer",10000,"Bangalore"));
        list.add(new Employee("Crime", "Manager", 32459, "Hyderabad"));
    }

    public static void display(Predicate<Employee> predicate, List<Employee> list) {
        for(Employee emp : list)
            if(predicate.test(emp))
                System.out.println(emp);


        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        populate(list);

        Predicate<Employee> p1 = employee -> employee.designation.equals("Manager");
        System.out.println("Managers: ");
        display(p1, list);

        Predicate<Employee> p2 = employee -> employee.city.equals("Hyderabad");
        System.out.println("Employees from Hyderabad");
        display(p2, list);

        Predicate<Employee> p3 = employee -> employee.salary < 20000;
        System.out.println("Employees that have salary < 20000");
        display(p3, list);

        System.out.println("All managers, devs from city Hyderabad");
        display(p1.and(p2), list);

        System.out.println("Employee information who are not managers");
        display(p1.negate(), list);

        Predicate<Employee> p4 = ceo -> ceo.designation.equals("CEO");
        for(Employee emp : list)
            if(p4.test(emp))
                System.out.println(emp);
    }
}

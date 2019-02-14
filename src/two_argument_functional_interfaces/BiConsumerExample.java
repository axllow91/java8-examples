package two_argument_functional_interfaces;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public interface BiConsumerExample<T, U> {
    void accept(T t, U u);

    // default method andThen()
}

class Employee1 {
    String name;
    double salary;

    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Test2 {
    public static void main(String[] args) {
        BiConsumer<String, String> c = (s1, s2) -> System.out.println(s1 + s2);
        c.accept("Me", "You");

        List<Employee1> l = new ArrayList<>();
        BiFunction<String, Double, Employee1> f = (name, salary) -> new Employee1(name, salary);
        l.add(f.apply("Me", 23440.50));
        l.add(f.apply("Rome", 33.50));
        l.add(f.apply("More", 24242.40));

        BiConsumer<Employee1, Double> c1 = (e, increment) -> e.salary += increment;
        for(Employee1 emp : l) {
            c1.accept(emp, 4000.0);
        }

        for(Employee1 emp : l) {
            System.out.println("Name: " + emp.name);
            System.out.println("Salary incremented: " + emp.salary);
            System.out.println();
        }

    }
}

package two_argument_functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/*
* example of a bi-functional interface<T- first type, U - second type, R return type>
* T - the type of the first argument to the function
* U - the type of the second argument to the function
* R - the type of the result of the function
* */
public interface BiFunctionExample<T,U,R> {
    R apply(T t, U u);
}


class Student {
    String name;
    int rollno;

    Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }
}

class Employee {
    int eno;
    String name;
    double dailyWage;

    public Employee(int eno, String name, double dailyWage) {
        this.eno = eno;
        this.name = name;
        this.dailyWage = dailyWage;
    }
}

class TimeSheet {
    int eno;
    int days;

    public TimeSheet(int eno, int days) {
        this.eno = eno;
        this.days = days;
    }
}



class Test1 {
    public static void main(String[] args) {
        // 2 input arguments and last is the return type
        BiFunction<Integer, Integer, Integer> f = (a, b) -> a * b;
        System.out.println(f.apply(2, 4));

        //
        List<Student> l = new ArrayList<>();
        BiFunction<String, Integer, Student> bf = (name, rollno) -> new Student(name, rollno);
        l.add(bf.apply("Marus", 99));
        l.add(bf.apply("Peul", 100));
        l.add(bf.apply("Cerco", 101));

        for(Student s : l) {
            System.out.println("name: " + s.name);
            System.out.println("rollno: " + s.rollno);
        }

        //
        Employee e = new Employee(101, "Meyou", 1500);
        TimeSheet t = new TimeSheet(101, 25);

        BiFunction<Employee, TimeSheet, Double> bf1 = (emp, timeSheet) ->  emp.dailyWage * timeSheet.days;
        System.out.println("Monthly salary: " + bf1.apply(e, t));
    }
}


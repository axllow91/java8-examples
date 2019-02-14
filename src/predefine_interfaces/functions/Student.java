package predefine_interfaces.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
* Program to find Student grade by using function
* */
public class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class TestStudent {

    public static void populate(List<Student> studentList) {

        studentList.add(new Student("Michael", 90));
        studentList.add(new Student("David", 53));
        studentList.add(new Student("James", 60));
        studentList.add(new Student("Keith", 66));
        studentList.add(new Student("Conan", 84));
        studentList.add(new Student("Brian", 99));
    }
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        populate(studentList);

        Function<Student, String> f = s -> {
            int marks = s.marks;
            if(marks >= 80) {
                return "A[Dictinction]";
            } else if(marks >= 60) {
                return "B[First Class]";
            } else if(marks >= 50) {
                return "C[Second Class]";
            } else if(marks >= 35) {
                return "D[Third Class]";
            } else {
                return "E[Failed]";
            }
        };

        for(Student s : studentList) {
            System.out.println("Student Name: " + s.name);
            System.out.println("Student Marks: " + s.marks);
            System.out.println("Student Grade: " + f.apply(s));
            System.out.println("-----------------------------");
        }

        System.out.println("Student Predicate");

        Predicate<Student> p = student -> student.marks >= 60;

        for(Student student: studentList){
            if(p.test(student)) {
                System.out.println("Student Name: " + student.name);
                System.out.println("Student Marks: " + student.marks);
                System.out.println("Student Grade: " + f.apply(student));
                System.out.println("-----------------------------");
            }
        }
    }
}

package predefine_interfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
* Demo for Predicate, Function & Consumer
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

    private static void populate(List<Student> list) {
        list.add(new Student("Me", 88));
        list.add(new Student("You", 50));
        list.add(new Student("Jug", 35));
        list.add(new Student("Lava", 83));
        list.add(new Student("Darwin", 63));
        list.add(new Student("Einstein", 99));

    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        populate(list);

        Predicate<Student> p = student -> student.marks >= 60;
        Function<Student, String> fs = student -> {
            int marks = student.marks;
            if(marks >= 80)
                return "A[Best]";
            else if(marks >= 60)
                return "B[Second]";
            else if(marks >= 50)
                return "C[Third]";
            else if(marks >= 35)
                return "D[Fourth]";
            else
                return "F[Failed]";
        };

        Consumer<Student> c = student -> {
            System.out.println("Student Name: " + student.name);
            System.out.println("Student Marks: " + student.marks);
            System.out.println("Student Grade: " + fs.apply(student));
            System.out.println("-------------------------------------");
        };

        for(Student st : list)
            if(p.test(st)) // this will test the marks
                c.accept(st); //
    }
}

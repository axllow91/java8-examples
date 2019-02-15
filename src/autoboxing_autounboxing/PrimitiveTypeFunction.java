package autoboxing_autounboxing;


import java.util.ArrayList;
import java.util.List;
import java.util.function.*;


/*
 * The following are various primitive Type Functional Interface for Function
 * 1. IntFunction : can take int type as input and return any type:
 *       public R apply(int i); -> R = the return type that we want to return
 * 2. LongFunction : can take long type as input and return any type:
 *       public R apply(long l);
 * 3. DoubleFunction : can take double type as input and return any type:
 *       public R apply(double d);
 * 4. ToIntFunction: It can take any type as input but always returns int type
 *       public int applyAsInt(T t) T = the type we want as input
 * 5. ToLongFunction: It can take any type as input but always returns long type
 *       public long applyAsLong(T t) T = the type we want as input
 * 6. ToDoubleFunction: It can take any type as input but always returns double type
 *       public double applyAsDouble(T t) T = the type we want as input
 * 7. IntToLongFunction: It can take int type as input and return long type
 *       public long applyAsLong(int i)
 * 8. IntToDoubleFunction: It can take int type as input and return double type
 *       public double applyAsLong(int i)
 * 9. LongToIntFunction: It can take long type as input and return int type
 *       public double applyAsInt(int i)
 * 10. LongToDoubleFunction: It can take long type as input and return double type
 *       public double applyAsDouble(long l)
 * 11. DoubleToIntFunction: It can take double type as input and return long type
 *       public long applyAsInt(double d)
 * 12. DoubleToLongFunction: It can take double type as input and return long type
 *       public long applyAsLong(double d)
 * 13. ToIntBiFunction: return type must be int type but inputs can be any type
 *       public long applyAsInt(T t, U u)
 * 14. ToLongBiFunction: return type must be long type but inputs can be any type
 *       public long applyAsLong(T t, U u)
 * 15. ToDoubleBiFunction: return type must be double type but inputs can be any type
 *       public long applyAsDouble(T t, U u)
 *
 * ****************************************************************
 *
 * The following 6 primitive versions available for Consumer:
 * 1. IntConsumer:
 *      public void accept(int value)
 * 2. LongConsumer:
 *      public void accept(long value)
 * 3. DoubleConsumer:
 *      public void accept(double value)
 * 4. ObjIntConsumer<T>
 *     public void accept(T t, int value)
 * 5. ObjLongConsumer<T>
 *     public void accept(T t, long value)
 * 6. ObjDoubleConsumer<T>
 *     public void accept(T t, double value)
 *
 * *****************************************************************
 *  Primitive Versions for Supplier:s
 *
 * 1. IntSupplier
 *     public int getAsInt()
 *
 * 2. LongSupplier
 *     public long getAsLong()
 *
 * 3. DoubleSupplier
 *     public double getAsLong()
 *
 * 4. BooleanSupplier
 *     public boolean getAsBoolean()
 * ******************************************************************
 *
 * Primitive versions for UnaryOperator
 * 1. IntUnaryOperator:
 *      public int applyAsInt(int i);
 *
 * 2. LongUnaryOperator:
 *      public long applyAsLong(long l);
 *
 * 3. DoubleUnaryOperator:
 *      public double applyAsDouble(double d);
 *
 * ******************************************************************
 *
 * Primitive versions for BinaryOperator
 * 1. IntBinaryOperator:
 *      public int applyAsInt(int i, int j)
 * 2. LongBinaryOperator;
 *      public long applyAsLong(long l1, long l2)
 * 3. DoubleBinaryOperator:
 *      public double applyAsDouble(double d1, double d2)
 * */


public class PrimitiveTypeFunction {
    public static void main(String[] args) {
        /* Demo program to find square of given integer by using Function */
        Function<Integer, Integer> f = i -> i * i;
        System.out.println("Using Function " + f.apply(5));

        /* Demo program to find square of given integer by using IntFunction */
        IntFunction<Integer> ifun = i -> i * i;
        System.out.println("Using IntFunction:" + ifun.apply(4));

        /*Demo program to find length of the given String by using Function*/
        Function<String, Integer> f1 = s-> s.length();
        System.out.println("Length Using function: "  + f1.apply("Romulus"));

        /* Demo program to find length of the given String by using ToIntFunction*/
        ToIntFunction<String> f2 = s -> s.length();
        System.out.println("Using ToIntFunction: " + f2.applyAsInt("Romulus Emperor"));

        /* Demo program to find square of given integer by using IntToDoubleFunction */
        IntToDoubleFunction id = i -> i * i;
        System.out.println(id.applyAsDouble(45)); // return will be double

        DoubleToLongFunction df = d -> (long)(d * d);
        System.out.println(df.applyAsLong(9999.3));

        // Demo program for Consumer
        System.out.println("\nDemo program using consumer");
        IntConsumer c = i -> System.out.println("The square of " + i + " is "  + (i * i));
        c.accept(99);

        System.out.println("\n");
        List<Employee> l = new ArrayList<>();
        populate(l);
        ObjIntConsumer<Employee> ce = (e, d) -> e.salary += d;
        for(Employee e : l)
            ce.accept(e,5000); // adding employees salary 5000

        // iterate through employees
        for(Employee e : l) {
            System.out.println("Name: " + e.name);
            System.out.println("Salary: " + e.salary);
            System.out.println();
        }

        /*
        * Demo program to generate 6 digit random OTP by using IntSupplier
        * */

        System.out.println("\nUsing IntSupplier: ");
        IntSupplier s = () -> (int)(Math.random() * 10); // Math.random() produces numbers from 0.0 < n < 1.0 (* 10 =>
        // => 0.0 * 10 = (int) 0, 0.1 * 10 = 1 ...., 0.9 * 10 = 9, 1.0 * 10 = 10)
        String otp = "";
        for(int i = 0; i < 6; i++)
            otp += s.getAsInt();

        System.out.println("The 6 digit OTP: " + otp);


        /*IF the input and output are the same type then we should go for UnaryOperator interface
        * it is a child of Function<T, T>
        * Represents an operation on a single operand that produces a result of the same type as its operand.
        * This is a specialization of Function for the case where the operand and result are of the same type.
        * */
        System.out.println("\nUnaryOperator function (child of Function<T,T>)");
        UnaryOperator<Integer> uo = i -> i * i;
        System.out.println(uo.apply(90));


        /*Binary Operator*/
        BiFunction<String, String, String> bif = (s1, s2) -> s1 + s2;
        System.out.println(bif.apply("AAASDSDS", "FFFFEZS"));

        System.out.println("\nUsing binary Operator: ");
        BinaryOperator<String> bop = (s1, s2) -> s1 + s2;
        System.out.println(bop.apply("ASuka", "Nagashi"));

        System.out.println("\nUsing Double Operator: ");

    }

    private static void populate(List<Employee> l) {
        l.add(new Employee("Dica", 110.0));
        l.add(new Employee("Ruca", 99.30));
        l.add(new Employee("Demetrius", 111.33));
        l.add(new Employee("Jim", 240.4));
        l.add(new Employee("Szukala", 240.34));
    }
}

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

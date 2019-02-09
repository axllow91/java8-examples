package lambdas;

/* Functional Interface with lambda*/
interface I {
    void add(int a, int b);
}

interface II {
    int getLength(String s);
}

interface III {
    int squareIt(int x);
}

public class Demo {
    public static void main(String[] args) {
        // This is calling type inference when compiler guess from the context
        // the type of variables (when calling the interface I the compiler will know the type of
        // the variables a and b from the interface abstract add()
        // See we do not need to implement the interface
       I i = (a,b) -> System.out.println("The sum is: " + (a + b));
       i.add(10,20);
       i.add(20,30);

       // II
        II ii1 = s -> s.length();
        II ii2 = String::length; // here we are using method reference
        System.out.println("The length is: " + ii1.getLength("Hellow"));
        System.out.println("The length is: " + ii2.getLength("Abracadabra"));

        III iii = x -> x * x;
        System.out.println("The square is: " + iii.squareIt(20));
    }
}

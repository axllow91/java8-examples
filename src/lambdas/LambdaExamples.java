package lambdas;

/*
 * Lambda expression are anonymous functions (they don't have a name like regular functions)
 * Lambda expression can take any numb of param we want none, 1, 2 and so on...
 * Similar to method body, lambda expr body can contain any numb of statements
 * If multiple statements are there curly bracers should be enclosed
 * If only one statement exist in lambda then the curly bracers are optional
 * if lambda expression returns something then we can remove the return keyword from statement
 * Not having any modifiers
 * Not having any return type
 * */

/*
 * Functional interface -> is a interface that contains only single abstract method (the interf. can have the other type of
 * method default, static).
 *
 * Examples: Runnable -> contains the run() method
 *           Callable -> contains the call() method
 *           ActionListener -> contains one method : actionPerformed()
 *           Comparable -> contains one method: compareTo()
 * All this interfaces are FUNCTIONAL INTERFACE
 * For Functional Interfaces they added a annotation @FunctionalInterface (this indicate will be using the functional
 * interface) if we do some mistake then the compiler (will check for mistakes) will rise an error at the time of compilation
 * If we the compiler find mistakes in the functional interface then will throw: unexpected @FunctionInterface annotation
 * (for the annotated interface) multiple non-overriding abstract methods present in interface created
 * Or if we have not created an abstract method inside a functional interface: error unexpected @FunctionalInterface
 * annotation, no abstract method found in interface "name of interface"
 * */

// Example of how you can create a functional interface
@FunctionalInterface
interface Interf {
    void m1(); // only one single abstract method

    default void m2() {
    }

    static void m3() {
    }
}


/* !!!!!!!!!!
 * FUNCTIONAL INTERFACE INHERITANCE
 * case 1 - an interface extends Functional Interface and child interface
 * does not contain any abstract method, then the child interface is ALWAYS FUNCTIONAL INTERFACE
 * */

@FunctionalInterface
interface InterfM {
    void m1();
}

// This will be always a functional interface
// even it is empty
interface InterfcC extends InterfM {

}

/*
 * case 2 - in the child interface, we can define
 * exactly same parent interface abstract method
 * */
@FunctionalInterface
interface P {
    void m1();
}

@FunctionalInterface
interface C extends P {
    void m1();
}


/*
 * case 3 - in the child interface we can't define
 * any new abstract methods otherwise we will get an error
 *
 * */

@FunctionalInterface
interface L {
    void m1();
}

// if you uncomment the interface will se the error
// Multiple non-overriding abstract methods found in interface D (from lambda package)
//@FunctionalInterface
//interface D extends L {
//    void m2();
//}

/*
 * case 4 - the child method that has not the annotation
 * @FunctionalInterface can create a abstract method when he already extends the super interface
 * */

@FunctionalInterface
interface G {
    void m1();
}

interface E extends G {
    void m2();
}


public class LambdaExamples {
    // Simple example of method
    public void say() {
        System.out.println("Hello");
    }

    // example 2
    public void add(int x, int y) {
        System.out.println(x + y);
    }

    // example 3
    public int getLength(String s) {
        return s.length();
    }

    public static void main(String[] args) {
        // The code above is an example how you can transform lambdas from methods
        // Transforming the method say from above into a lambda
        // we get rid of modifier(public), get rid of return type(void) and get rid of the name(say)
        // here we go
        //  () -> System.out.println("Hello");

        // example 2
        // Transforming the add method into a lambda expression
        // (int x, int y) -> System.out.println(x + y);
        // Sometimes the compiler can guess the type of param inside the lambda
        // so we can remove the type of variables
        // (x, y) -> System.out.print(x + y);

        // example 3
        // Transforming getLength method int a lambda expression
        // (String s) -> { return s.length() }
        // (s) -> return s.length();
        // (s) -> s.length(); --> will be returned automatically because compiler will know u want to return
        // (s) = are optional if we have only one variable inside the parenthesis
        // so the lambada will be s -> s.length(); --> simplified

        // FUNCTIONAL INTERFACE
    }
}

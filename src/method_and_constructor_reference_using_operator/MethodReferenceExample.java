package method_and_constructor_reference_using_operator;

/*
 * Method reference: is a shorthand syntax for a lambda expression that executes ONE method.
 * General syntax: Object::methodName
 * In other words instead of using anonymous class you can user a lambda expression
 * but if just calls one method you can use METHOD REFERENCE
 * There are 4 types of method reference:
 *      1.method reference to a static method
 *      2.method reference to an instance method of an object of a particular type
 *      3.method reference to an instance method of an existing object
 *      4.method reference to a constructor
 *
 * Instance example:
 *      Object::methodName -> Test t = new Test()
 *                            t::m2()
 *
 * */
interface Interf {
    void m1();
}

public class MethodReferenceExample {
    public static void m2() {
        System.out.println("Implementation by Method Reference");
    }

    public static void main(String[] args) {
        Interf i = () -> {
            System.out.println("lambda implementation");
            // TODO
        };

        i.m1();

        // to enable method reference we need to know that the only restriction is that
        // methods need to have the same argument types
        // with the method we want to reference
        // internally refer static method m2
        Interf i1 = MethodReferenceExample::m2; // here we are expecting m1 method but we refer the static method m2
        i1.m1(); // calling m1 internally will be called m2 method

        /*888888888888888888888888888888888888888888888888888888888888*/
    }
}

/* There are 2 ways to create a thread
*  1. One by extending Thread class
*  2. By implementing Runnable interface
* */
class Test {
    public static void main(String[] args) {
        // here we are providing new implementation
        Runnable r = () -> { // -> child thread is responsible for running this code
            for(int i = 0; i < 10; i++)
                System.out.println("Child Thread!");
        };

        Thread t = new Thread(r);
        t.start();
        // from there and below we have 2 threads available main thread and child thread
        for(int i = 0;i < 10; i++)
            System.out.println("Main Thread");
    }
}

class Test1 {

    public void m1() {
        for(int i =0; i < 10; i++)
            System.out.println("Child Thread");
    }
    public static void main(String[] args) {
        // Replacing lambda expression with Method reference
        Test1 t1 = new Test1();
        // -> we are using only m1 method implementation and use the existent implementation
        // code reusable
        Runnable r = t1::m1;

        Thread t = new Thread(r);
        t.start();

        for(int i =0; i < 10; i++)
            System.out.println("Main Thread");
    }
}

// Constructor reference
interface Interf1 {
    Sample get();
}

class Sample {
    Sample() {
        System.out.println(
                "Sample constructor Execution Object creation"
        );
    }

    public static void main(String[] args) {

        System.out.println("With lambda expression");
        Interf1 i = () -> {
                Sample s = new Sample();
                return s;
        };

        /*
        * Whenever we are calling i.get() method, internally the lambda expression above will get
        * executed
        * */
        Sample s1 = i.get();
        //System.out.println(s1);

        System.out.println("With Constructor Reference");
        Interf1 i1 = Sample::new; // -> with constructor reference
        Sample s2 = i1.get();
        //System.out.println(s2);


    }
}

package lambdas;

interface A {
    void m1();
}

public class InvokingFunctionalInterface implements A {
    /*
     * Invoking FUNCTIONAL INTERFACES
     * without lambda expression
     * */
    public void m1() {
        System.out.println("m1() method implementation");
    }
}

class Test1 {
    public static void main(String[] args) {
        A a = new InvokingFunctionalInterface();
        a.m1();
    }
}

class Test2 {
    public static void main(String[] args) {

        /*
         * Invoking FUNCTIONAL INTERFACES
         * with lambda expression
         * is the same with having the implemented method inside
         * Compiler knows we are referring to the m1() method / Right know we are inside m1()
         * */
        A a = () -> System.out.println("m1() method implementation with lambda");

        // calling m1 method
        a.m1();
    }
}

package default_methods_inside_interf;

/*
* Default methods with multiple inheritance
*
*
* */

interface Left {
    default void m1() {
        System.out.println("Left default method!");
    }
}

interface Right {
    default void m1() {
        System.out.println("Right default method");
    }
}

public class DefaultMethodWithInheritance implements Left, Right {
    // There is a problem with multiple implementation of the same method from different interfaces
    // The compiler will not know what method to use for your written code
    // So one of the solution that you can come with is to write your own implementation of the method
//    public void m1() {
//        System.out.println("My own implementation");
//    }

    // The other thing is to call which method we want
    // We can call the method we like like this
    public void m1() {
        System.out.println("Inside m1 method. Calling: ");
        Left.super.m1(); // or
        Right.super.m1();
    }

    public static void main(String[] args) {
        DefaultMethodWithInheritance df = new DefaultMethodWithInheritance();
        df.m1();
    }
}

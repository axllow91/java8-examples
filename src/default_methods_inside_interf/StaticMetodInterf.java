package default_methods_inside_interf;

/* From 1.8 > we can declare static methods inside of an interface!
* What is the purpose of static methods inside interface ?
* A: Just to define utilities methods. Any person can call this methods
* just by using the interface name.
* Overriding is not applicable for static methods inside of an interface
* */

interface Interf {
    static void m1() {
        System.out.println("Interface static method");
    }
}

interface Interf1 {
    static void m1() {
        System.out.println("Interf1 static method");
    }
}

public class StaticMetodInterf implements Interf, Interf1 {

    // It is valid to declare this method as the same with the interfaces
    // But is not overridden
    public static void m1() {
        // this is not overridden
    }

    public static void main(String[] args) {
        Interf i = new StaticMetodInterf();
        // i.m1(); -> incorrect call
        // StaticMetodInterf.m1(); -> incorrect call
        Interf.m1(); // -> corret call of an interface static method
    }
}

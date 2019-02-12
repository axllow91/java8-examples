package InnerClasses;


/*
 * Inner class means one class that is a member of another class. There are basically 4 types of inner classes in java:
 *   - Nested Inner classes - we can't have static methods inside of a nested class because is associated with an object
 * of it's outer class so it cannot define any static method for itself
 *   - Method Local inner classes -  Local inner class cannot access non-final local variable
 * till JDK 1.7. Since JDK 1.8, it is possible to access the non-final local variable in method local inner class.
 *   - Anonymous Inner classes - They have no name at all. They are created in two ways :
 *          # as a subclass of the specified type
 *          # as implementer of the specified interface
 *   - Static nested classes - Static nested classes are not technically an inner class.
 *  They are like a static member of outer class.
 * Inner class methods can access the date from the scope which they are defined - including the data that would otherwise
 * will be private
 * Inner classes can be hidden my other classes in the same package
 * Anonymous inner classes are handy when you want to define callbacks without writing a lot of code.
 *
 * */
class InnerClassExample {
    // Nested Inner Classes
    class NestedInnerClass {
        public void show() {
            System.out.println("I'm inside a nested inner class that is inside in another class!");
        }
    }

    // Method Local Inner Classes - classed declared inside a of a method
    void outerMethod1() {
        // it can be a non-final variable if we are using jdk 1.8 or > until then we need to use final variable
        final int x = 99;
        class MethodLocalInner {
            private void innerMethod() { // access to this method can be private
                System.out.println("Inside outerMethod()" +
                        "\nx=" + x);
            }
        }

        // creating a obj method local inner class reference
        MethodLocalInner methodLocalInner = new MethodLocalInner();
        methodLocalInner.innerMethod(); // call the method local inner class
    } // end of outerMethod()


    // Static inner class
    public static void outerMethod2() {
        System.out.println("Inside outerMethod2()");
    }

    static class InnerStatic {
        public static void sayHello() {
            System.out.println("Hello from a static method inside a static nested Class");
        }

        public static void main(String[] args) {
            System.out.println("Inside a Inner class Method");
            outerMethod2();
        }
    }

    // Anonymous Inner Class
    void show() {
        System.out.println("I'm in a show method of a super class");
    }
}
// Anonymous Inner Class
// # ex1: as a subclass of the specified type
/*
 * In the above code, we have two class Demo and Flavor1Demo. Here demo act as super class
 * and anonymous class acts as a subclass, both classes have a method show().
 * In anonymous class show() method is overridden.
 * */
class Flavor1Demo {
    static InnerClassExample example = new InnerClassExample() {
      void show() {
          super.show();
          System.out.println("i'm in Flavor1Demo class");
      }
    };

    public static void main(String[] args) {
        example.show();
    }
}

// Anonymous Inner Class
// # ex2: as implementer of specified interface
interface Hello {
    void show();
}

class Flavor2Demo {
    static Hello h1 = new Hello() {
        public void show() {
            System.out.println("Inside Flavor2Demo class");
        }
    }; // OR


    static Hello h2 = () -> System.out.println("Inside Flavor2Demo class (lambda example)");

    public static void main(String[] args) {
        h1.show();
        h2.show();
    }
}

class Demo {
    public static void main(String[] args) {
        // InnerClassExample is the Outer class and NestedInnerClass is the inner class
        InnerClassExample.NestedInnerClass nested = new InnerClassExample().new NestedInnerClass();
        nested.show();

        // Method Local Inner class
        InnerClassExample outerClass = new InnerClassExample(); // -> it may be called InnerClassExample but it's the outer class
        outerClass.outerMethod1(); // calling the outer method will call the inner class

        // calling a method from inside a nested inner class
        InnerClassExample.InnerStatic.sayHello();
    }
}

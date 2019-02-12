package CollectionsOverview;

/*
* This class is an example when we can't replace anonymous classes with lambda expression
* Will see examples when we can't use lambda expression.
* Anonymous classes are more powerful than lambda expression because they can extend concrete classes, abstract classes
* and implement multiple abstract method of an interface and lambda can only implement one abstract method
* They are not the same (equal) only if we talk about functional interface!
* */

// Example of concrete class
// Lambda expression can't extend concrete class
public class Test1 {
}

class Demo {
    public static void main(String[] args) {
        // This is an anonymous inner class that extends the concrete class Test
        Test1 test1 = new Test1() {

        };
    }
}

// Lambda expression can't extends an abstract class
abstract class Test2 {

}

class Demo1 {
    public static void main(String[] args) {
        // Anonymous inner class that extends Abstract class
        Test2 test2 = new Test2() {

        };
    }
}

// Lambda expression can implement only on abstract method
// see example 4
interface Test3 {
    void m1();
    void m2();
    void m3();
}

class Demo2 {
    public static void main(String[] args) {
        // Anonymous inner class that implements
        // an interface which contains multiple methods
        Test3 test3 = new Test3() {
            @Override
            public void m1() {

            }

            @Override
            public void m2() {

            }

            @Override
            public void m3() {

            }
        };
    }
}

interface Test4 {
    void m1();
}

class Demo4 {
    public static void main(String[] args) {
        // Anonymous inner class that implements an interface
        // which contains only one abstract method
//        Test4 test4 = new Test4() {
//            @Override
//            public void m1() {
//
//            }
//        };

        Test4 test4 = () -> System.out.println("Inside m1() method");
    }
}

// Another difference is the this keyword. In anonymous class "this"
// reference to a thing and in lambda expression to another thing
// example
interface I {
    void m1();
}

class TestThis {

    int x = 8888; // outer class variable

    void m2() {
        I i = new I() {
            private int x = 9999; // local method inner class variable
            @Override
            public void m1() {
                // inside Anonymous inner class  this will refer only to current inner class object instances variable
                System.out.println(this.x);
                System.out.println(TestThis.this.x); // accessing the outer class variables
            }
        };
        i.m1();
    }

    public static void main(String[] args) {
        TestThis t = new TestThis();
        t.m2();
    }
}

//
interface I1 {
    void m1();
}

class TestThis1 {
    int x = 8888;
    public void m2() {
        I1 i1 = () -> {
            // inside lambda expression you cannot declare instance variables
            // modifiers are not allowed inside lambda expression
            /*private*/ int x = 9999; // gives error
            System.out.println(x);
            // this keyword will refer to the outer class variable
            // when we are using it inside the lambda expression
            // the opposite of using anonymous classes
            System.out.println(this.x);
        };
        i1.m1();
    }

    public static void main(String[] args) {
        TestThis1 t = new TestThis1();
        t.m2();
    }
}

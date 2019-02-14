package default_methods_inside_interf;

/*
* Until 1.7 java version we had only abstract methods
* From 1.8 > they have introduced default methods and static methods
* So from 1.8 version we can happily have concrete methods inside of an interface
* Every variable that is present into a interface is implicitly public static final
*
*
*
* */
public interface DefaultMethods {
    int x = 10;  // public static final implicitly

    // declare a default method using the "default"
    // default is not a modifier just a keyword
    // this method can be override
    default void m1() {
        System.out.println("Inside a default method");
    }
}

class Test implements DefaultMethods{

    // here we override the default concrete method from the interface
    public void m1() {
        System.out.println("I've override the m1() default method from the interface");
    }

    public static void main(String[] args) {
         DefaultMethods df = new Test();

         // trying to change the value of a variable inherited from interface
        // df.x = 99; --> error

        //
        df.m1();
    }
}

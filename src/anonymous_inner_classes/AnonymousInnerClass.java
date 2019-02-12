package anonymous_inner_classes;

// Anonymous inner class is a class that has no name
public class AnonymousInnerClass {
    public static void main(String[] args) {
        // You cannot instantiate interfaces because you defy the Object oriented model
        // They are created to be like a contract - the promise made to an implementer class
        // that the contract between them will be fulfill
        // Runnable r = new Runnable(); - wrong


        // This is perfectly fine because we are writing a class
        // that implements Runnable interface
        // We are not creating a runnable object
        // it is an object of the implemented class that implements Runnable
        // has the reference of Runnable interface
        Runnable r = new Runnable() { // starts from here
            public void run() {
                for(int i = 0; i < 10; i++)
                    System.out.println("Child Thread");
            }
        };// ends here

        Thread t = new Thread(r);
        t.start();

        for(int i = 0; i < 10; i++)
            System.out.println("Main Thread!");
    }
}

class ExampleWithLambda {
    public static void main(String[] args) {
        Runnable r = () -> {
            for(int i = 0; i < 10; i++)
                System.out.println("Child Thread");
        };

        Thread t = new Thread(r);
        t.start();

        for(int i =0; i < 10; i++)
            System.out.println("Main Thread");
    }
}

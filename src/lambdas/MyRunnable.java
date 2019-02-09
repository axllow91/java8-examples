package lambdas;

public class MyRunnable implements Runnable { // this is a way of defining a thread
    @Override
    public void run() { // this code is executed by the child Thread
        for(int i = 0; i < 10; i++)
            System.out.println("Child Thread");
    }
}

class ThreadsDemo1 {
    public static void main(String[] args) {
        // Up to now we have only the Main Thread

        Runnable r = new MyRunnable();

        Thread t1 = new Thread(r);
        // after the execution call of t.start() we have 2 threads and will be run simultaneously
        // until then we have only one thread. The main thread creates a runnable obj, creates a
        // thread obj and executes the start method
        t1.start();

        for(int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}

class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r  = () -> {
            for(int i = 0; i < 10; i++)
                System.out.println("Child2 Thread");
        };

        Thread t2 = new Thread(r);
        t2.start();

        for(int i = 0; i < 10; i++)
            System.out.println("Main Thread");
    }
}

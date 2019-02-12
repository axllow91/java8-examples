package predefine_interfaces.consumer;

/*
* Consumer interface: Sometimes our requirement is we have to provide some input value, perform certain operation,
* but no required to return anything, then we would go for Consumer; example: Consumer can be used to consume object
* and perform certain operation
* Consumer interface has only one abstract method accept(T t) which means is a functional interface like the predicate
* function so on... and we can enhance lambda expression
* */
// Example how the Consumer interface looks like
public interface ConsumerExample<T> {
    void accept(T t);
}

class Test {
    public static void main(String[] args) {
        Co<String> c1 = s -> System.out.println(s);
        c1.accept();
    }
}

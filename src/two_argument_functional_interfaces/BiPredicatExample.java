package two_argument_functional_interfaces;

import java.util.function.BiPredicate;

/*
* example of bi-predicate
* */
public interface BiPredicatExample<T, U> {
    // bi predicate will take 2 arguments type
    boolean test(T t, U u);
}

class Test {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> p = (a,b) -> (a + b) % 2 == 0;
        System.out.println(p.test(10, 20));
        System.out.println(p.test(15, 20));
    }
}

package predefine_interfaces.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/*
 * Predicate -  we can use it to check a condition for particular test.
 * Predicate<T>: A predicate is a function with a single argument and returns boolean value
 * Introduced in 1.8 version
 * You can find this interface in the java.util.function package (which has multiple predefined interfaces)
 * Contains only one abstract method test(T t) and the return is a boolean value and multiple default methods
 * Predicate Interface can return only one Type param
 * Predicate interface has a static function that is called isEqual(Object obj)
 *
 * */
// how the Predicate interface look like
public interface PredicateExample<T> {
    boolean test(T t);
}

class Test implements PredicateExample<Integer> {

    public boolean test(Integer i) {
        if (i > 10)
            return true;
        else return false;
    }


    public static void m1(Predicate<Integer> p, int[] x) {
        for (int i : x)
            if (p.test(i))
                System.out.println(i);
    }

    public static void main(String[] args) {
        Integer i = 9;
        PredicateExample predicateExample = new Test();
        System.out.println(predicateExample.test(i));

        System.out.println("Using predicate to check the length(Lambda)");
        // check the length of a given string is greater than 3 or not using lambda.
        PredicateExample<String> predicate = s -> (s.length() > 3);
        System.out.println(predicate.test("Sukabliet"));
        System.out.println(predicate.test("Aaa"));

        // Write a predicate to check whether the give collection is empty or not
        PredicateExample<Collection> p = c -> c.isEmpty();
        System.out.println(p.test(new ArrayList()));

        /* We can join predicates into a single predicate using the following methods:
         * and()
         * or()
         * negate()
         * and they are exactly the same as logical AND, OR complement operators
         * */

        int[] x = {0, 5, 10, 15, 20, 25, 30};

        // Using the java 1.8 predicate interface
        System.out.println("\nUsing the join predicates methods!");
        Predicate<Integer> p1 = pp -> pp > 10;
        Predicate<Integer> p2 = ppp -> ppp % 2 == 0;

        System.out.println("The Numbers Greater than 10: ");
        m1(p1, x);
        System.out.println("The even numbers are: ");
        m1(p2, x);

        System.out.println("The numbers not greater than 10: ");
        m1(p1.negate(), x);
        System.out.println("The numbers greater than 10 and even are");
        m1(p1.and(p2), x);
        System.out.println("The numbers greater than 10 or eve");
        m1(p1.or(p2), x);

        // Predicate example with array of strings; see what values starts with the letter K
        String[] names1 = {"Sunny", "Manny", "Mey", "Key", "Kramer", "Jeremy"};
        Predicate<String> startsWith = s -> s.charAt(0) == 'K';
        System.out.println("The names that starts with 'K': ");
        for (String s : names1)
            if (startsWith.test(s))
                System.out.println(s);

        // Predicate example to remove null values and empty string from the given list
        String[] names2 = {"Sunny", "", "Mey", "", "", "Jeremy"};
        Predicate<String> nullValues = s -> s != null && s.length() > 0;
        ArrayList<String> list = new ArrayList<>();

        for (String s : names2)
            if (nullValues.test(s))
                list.add(s);


        System.out.println("List is");
        System.out.println(list);
    }
}



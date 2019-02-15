package method_and_constructor_reference_using_operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Numbers {
    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }

    public static List<Integer> findNumbers (
            List<Integer> l,
            BiPredicate<Integer, Integer> p
    ) {
        List<Integer> newList = new ArrayList<>();
        for(Integer i : l)
            if(p.test(i, i + 10))
                newList.add(i);

            return newList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 3, 44, 19, 40, 34);

        // Using anonymous class
        System.out.println("Using Anonymous class: " + findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        }));

        // Using lambda expression
        System.out.println("Lambda expression: " + findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2)));

        // Using a method reference
        System.out.println("Method Reference: " + findNumbers(list, Numbers::isMoreThanFifty));

    }
}

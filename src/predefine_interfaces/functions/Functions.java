package predefine_interfaces.functions;

import java.util.Scanner;
import java.util.function.Function;

/*
 * Function are exactly same as predicates except that function ca return any type of result but function should(can)
 * return only one value and that value can be any type as per our requirement.
 * To implement functions oracle people introduced Function interface in 1.8 version
 * Function interface present in java.util.function package
 * Functional Interface contains only one method i.e apply()
 * Function is a Functional Interface and hence it can refer lambda expression
 * We can combine multiple function together to form more complex functions. For this Functions interface defines the
 * following 2 defaults:
 * f1.andThen(f2) : first f1 will be applied and then for the result f2 will be applied
 * f1.compose(f2) : first f2 will be applied and then for the result f1 will be applied (opposite of andThen())
 *
 * */
// example of the real interface Function<T, R>
public interface Functions<T, R> {
    R apply(T t);
}

class Test {
    public static void main(String[] args) {
        // Here we are using the already implemented interface
        Function<String, Integer> fs = s -> s.length();
        System.out.println(fs.apply("Something"));
        System.out.println(fs.apply("Something else"));

        String s = "Something happened we need to fix it";
        Function<String, String> f1 = s1 -> s1.replaceAll(" ", "|");
        System.out.println(f1.apply(s));

        // Program to find number of spaces present in the given String by using function
        // using the string above
        Function<String, Integer> f2 = s1 -> s1.length() - s1.replaceAll(" ", "").length();
        System.out.println(f2.apply(s));


        // Chaining methods example
        System.out.println("\nChaining methods for functions...");
        Function<String, String> fct1 = s1 -> s1.toUpperCase();
        Function<String, String> fct2 = s2 -> s2.substring(0,4);

        System.out.println("The result of fct1: " + fct1.apply("Eminem"));
        System.out.println("The result of fct2: " + fct2.apply("Dean Martin"));

        // Chaining
        // takes the first function apply method
        // then takes the second function apply method w
        System.out.println("The result of fct1.andThen(fct2): " + fct1.andThen(fct2).apply("EMINEM"));

        // First makes a substring from the string dean martin
        // then make it uppercase
        System.out.println("The result of fct1.compose(fct2): " + fct1.compose(fct2).apply("Dean Martin"));


        /*
        * Program that demonstrate the difference between andThen() and compose()
        * */
        Function<Integer, Integer> fu1 = i -> i + i;
        Function<Integer, Integer> fu2 = i -> i * i * i;

        System.out.println(fu1.andThen(fu2).apply(2)); // fu1 = 4, fu2 = 4 * 4 * 4 = 64 -> fu2 will be the result

        System.out.println(fu1.compose(fu2).apply(2)); // fu2 = 8, fu1 = 8 + 8 = 16 -> fu1 will be the result

        // Example of using Function Chaining
        Function<String, String> fc1 = ss -> ss.toLowerCase();
        Function<String, String> fc2 = ss -> ss.substring(0, 6); // username with 6 letters

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String username = scanner.next();

        System.out.println("Enter Password: ");
        String password = scanner.next();

        if(fc1.andThen(fc2).apply(username).equals("marian") && password.equals("java"))
            System.out.println("Valid user");
        else
            System.out.println("Invalid user");

        // Function interface Static method : identity()
        // Returns a function that always returns its input argument.
        Function<String, String> f3 = Function.identity(); // returns the input of argument
        String s1 = f3.apply("Eminem");
        System.out.println(s1);

    }
}

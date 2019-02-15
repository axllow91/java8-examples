package autoboxing_autounboxing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

//interface IntPredicate {
//    boolean test(int i);
//    // default methods : and(), or(), negate()
//}
//
//interface LongPredicate {
//    boolean test(long l);
//    // default methods : and(), or(), negate()
//}
//
//interface DoublePredicate {
//    boolean test(double d);
//    // default methods : and(), or(), negate()
//}


public class Autoboxing {
    public static void main(String[] args) {
        // Autoboxing is automatically conversion from primitive to Object
        // Internally after compilation the lane below will be
        // Integer i = Integer.valueOf(10) -> compiler is responsible of converting
        // until 1.4 > this will have been invalid
        Integer i = 10;


        // Internally after compilation
        // int x = integer.intValue();
        Integer integer = new Integer(10);
        // from 1.5 compiler can converts Integer(Wrapper Class) objects into primitive automatically
        // this is called auto unboxing
        int x = integer;


        /*
        *  Two facts why we store object classes instead primitive on collection:
        *  Java primitives types are not reference types (ex: an int is not an object)
        *  Java does generics using type-erasure of reference types (ex List<?> is really a List<Object> at run-time)
        *
        * */
        List<Integer> list = new ArrayList<>();

        // Type argument cannot be a primitive
        // List<int> list = new ArrayList<>(); -> incorrect

        //
        int y[] = {0, 5, 10, 15, 20, 25};

        // example below makes  6 times autoboxing and 6 times which creates performance problems
        Predicate<Integer> p = i1 -> i1 % 2 == 0;
        for(int x1 : y)
            if(p.test(x1)) // 6 times autoboxing
                System.out.println(x1); // 6 times autounboxing


        // To resolve the above problem they introduced primitive functional interface that takes
        // primitive types as input and return primitive types. Hence autoboxing and autounboxing won't be
        // required, which improves performance
        // Following predicate interfaces are: 1. IntPredicate(int i), 2. LongPredicate(long l),
        // 3. DoublePredicate(double d)
        // Solution for the problem above
        int y1[] = {0, 5, 10, 15, 20, 25};

        IntPredicate intp = ii -> ii % 2 == 0;
        for(int x1 : y1)
            if(intp.test(x1)) // no autoboxing
                System.out.println(x1); // no autounboxing
    }
}

package CollectionsOverview;

import java.util.*;

/*
 * What is a Collection - is a group of objects represented by a single entity
 * What are various type of Collection
 * 1. List Concept: We go for list when we want to keep the insertion order
 *                  we want to have duplicates
 *                  (ArrayList, LinkedList, Vector, ... ,Stack)
 * 2. Set Concept: We go for set when we don't want to have duplicates values
 *                 You don't worry about the order of how they will be displayed
 *                 HashSet treeSet2(SortingSet)
 * 3. Map Concept: When you want to map keys to values
 *                 Does not hold duplicates keys; each key can map at most one value
 *                 They not guarantee the order of value
 * */


/*
 * Comparator interface contains only one method - abstract method compare() SAM - single abstract method
 * which make this interface Functional Interface and we can happily apply lambda expression
 * This comparator is used when we want to define our own sorting (customized sorting)
 * compare 2 object
 * For example if we want to compare 10 and 20, we know actually that we want first 10 and then 20
 * but how then the JVM will know how to compare this two.
 * For this JVM use internally the method Comparator compare() method to compare two objects:
 * compare(10, 20) -> compare(Obj obj1, Obj obj2)
 * return -1 if obj1 has to come before obj2
 * return positive if obj2 has to come after obj1
 * return 0 if they are equal
 * */
public class CollectionRefresh {

    private static void treeSetWithoutLambda() {
        System.out.println("\n----Sorting treeSet1 without lambda----");
        TreeSet<Integer> treeSet1 = new TreeSet<>(); // sorted set
        treeSet1.add(10);
        treeSet1.add(30);
        treeSet1.add(2);
        treeSet1.add(4);
        treeSet1.add(1);
        treeSet1.add(15);

        System.out.println(treeSet1);
    }

    private static void treeSetLambda() {
        System.out.println("\n----Sorting treeSet2 with lambda----");
        TreeSet<Integer> treeSet2 = new TreeSet<>(
                (x, y) -> (x > y) ? -1 : (x < y) ? 1 : 0 // descending order
        ); // sorting this set with the help of lambda expression
        treeSet2.add(10);
        treeSet2.add(30);
        treeSet2.add(2);
        treeSet2.add(4);
        treeSet2.add(1);
        treeSet2.add(15);

        System.out.println(treeSet2);
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Monica");
        list.add("Emma");
        list.add("Denmkar");
        list.add("Ciri");
        list.add("Londva");

        System.out.println(list);

        // Sorting the array list with comparator without lambda expression and without lambda expression
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(0);
        numbers.add(40);
        numbers.add(2);

        // insertion order is the same (10, 20, 30, 0, 40,2)
        System.out.println("Before sorting: " + numbers);

        // MyComparator comparator = new MyComparator();

        // operation of sorting using my customized comparator
        // that uses to compare 2 Integer object
        // Collections.sort(numbers, comparator);
        // Compiler guess what type we are using and let us compare the objects with the help of Collection compare()
        // so we can use directly the compare method into lambda expression
        Collections.sort(numbers, (o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
        // after sorting
        System.out.println("After sorting: " + numbers);


        Set<String> set = new TreeSet<>(); // HashSet for unordered set | treeSet2 - ordered set called as SortedTree
        set.add("America");
        set.add("Europa");
        set.add("Africa");
        set.add("Antarctica");

        System.out.println(set);


        treeSetWithoutLambda();

        treeSetLambda();


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Kevin");
        map.put(2, "Marian");
        map.put(3, "Elene");
        map.put(4, "Cyprus");

        System.out.println(map.get(1));
        System.out.println(map.get(1).equals(map.get(2)) ? "yes" : "no");
        System.out.println(map);

//        // Without lambda
//        TreeMap<Integer, String> t = new TreeMap<>();
//        t.put(4, "Second");
//        t.put(2, "You");
//        t.put(5, "Zubra");
//        t.put(3, "Lambda");
//        t.put(1, "Me");
//
//        System.out.println(t);

        TreeMap<Integer, String> t = new TreeMap<>((x,y) -> (x > y) ? -1 : (x < y) ? 1 : 0);
        t.put(4, "Second");
        t.put(2, "You");
        t.put(5, "Zubra");
        t.put(3, "Lambda");
        t.put(1, "Me");

        System.out.println(t);

    }
}

//class MyComparator implements Comparator<Integer> {
//    @Override
//    public int compare(Integer o1, Integer o2) {
////        if(o1 > o2)
////            return -1;
////        else if(o1 < o2)
////            return 1;
////        else
////            return 0;
//        return (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0;
//    }
//}

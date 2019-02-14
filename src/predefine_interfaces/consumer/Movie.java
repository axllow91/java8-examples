package predefine_interfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/*
* Consumer chaining methods
*
* */
public class Movie {
    String name;
    String hero;
    String heroine;
    String result;

    public Movie(String name, String hero, String heroine, String result) {
        this.name = name;
        this.hero = hero;
        this.heroine = heroine;
        this.result = result;
    }
}

class TestMovie {

    private static void populate(List<Movie> list) {
        list.add(new Movie("Transformers 3", "Some Robot", "Some girl", "Hit"));
        list.add(new Movie("Transport 3", "Some guy", "", "Flop"));
        list.add(new Movie("Batman", "Batman", "", "Hit"));
        list.add(new Movie("Super girl", "", "Super girl", "Hit"));
        list.add(new Movie("Witcher 3", "Geralt of Rivia", "Yennefer", "Hit"));
    }

    public static void main(String[] args) {
        List<Movie> m = new ArrayList<>();
        populate(m);

        Consumer<Movie> c = m1 -> {
            System.out.println("Movie name: " + m1.name);
            System.out.println("Movie name: " + m1.hero);
            System.out.println("Movie name: " + m1.heroine);
            System.out.println();
        };
        for(Movie mv : m)
            c.accept(mv);


        /* ********************
         *** Chaining Methods ***
         * ********************/
        Consumer<Movie> c1 = m1 -> System.out.println("Movie: " + m1.name + " is ready to release");
        Consumer<Movie> c2 = m1 -> System.out.println("Movie " + m1.name + " is just released and it is " + m1.result);
        Consumer<Movie> c3 = m1 -> System.out.println("Movie " + m1.name + " information storing in the database");

        Consumer<Movie> chainedC = c1.andThen(c2).andThen(c3);

        Movie movie1 = new Movie("Transport 4", "", "", "Hit");
        chainedC.accept(movie1);

        Movie movie2 = new Movie("I don't know what i'm doing", "", "", "Flop");
        chainedC.accept(movie2);
    }
}

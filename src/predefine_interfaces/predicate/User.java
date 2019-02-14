package predefine_interfaces.predicate;

import java.util.Scanner;
import java.util.function.Predicate;

/*
* Program for user auth by using predicate
* */
public class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class TestUser {
    public static void main(String[] args) {
        Predicate<User> p = user -> user.username.equals("me") && user.password.equals("1234");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();

        User user = new User(username, password);

        if(p.test(user))
            System.out.println("Valid user");
        else
            System.out.println("Invalid user");



    }
}

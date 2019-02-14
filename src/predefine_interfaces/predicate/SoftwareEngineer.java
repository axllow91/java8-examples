package predefine_interfaces.predicate;

import java.util.Scanner;
import java.util.function.Predicate;

/*
* Program to check whether SoftwareEngineer is allowed into pub or not by using Predicate?
* */
public class SoftwareEngineer {
    String name;
    int age;
    boolean hasGf;

    public SoftwareEngineer(String name, int age, boolean hasGf) {
        this.name = name;
        this.age = age;
        this.hasGf = hasGf;
    }

    public String toString() {
        return name;
    }
}

class TestEngineer {
    public static void main(String[] args) {
        SoftwareEngineer[] list = {new SoftwareEngineer("me", 99, true),
                new SoftwareEngineer("you", 10, false),
                new SoftwareEngineer("Haram", 20, true),
                new SoftwareEngineer("Elvis", 34, true),
                new SoftwareEngineer("Darvai", 50, false)};

        Predicate<SoftwareEngineer> ps = sf -> sf.age > 24 && sf.hasGf;

        System.out.println("Allowed sf in pub: ");
        for(SoftwareEngineer sf : list)
            if(ps.test(sf))
                System.out.println(sf.name + " is allowed to enter the PUB");
            else
                System.out.println(sf.name + " is not allowed to enter the PUB");
    }
}

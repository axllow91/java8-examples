package predefine_interfaces.supplier;

import java.util.Date;
import java.util.function.Supplier;

/*
* Supplier - Sometimes our requirement is we have to get some value based on same operation like
* supply Student obj
* supply Random name
* supply Random OTP
* supply Random Password
* etc..
* For this type of requirements we should go for Supplier
* Supplier can be used to supply items(objects)
*
*
* Supplier interface won't take any input and it will always supply objects.
* Supplier Functional Interface contains only one method get().
* */
public interface SupplierInterface<R> {
    R get();
}

class Test {
    public static void main(String[] args) {
        // Using the java Supplier interface
        Supplier<String> s = () -> {
            String[] s1 = {"Sunny", "Bunny", "Chinny", "Pinny"};
            int x = (int)(Math.random() * 4);
            return s1[x];
        };

        System.out.println(s.get());
        System.out.println(s.get());
        System.out.println(s.get());

        // Supplier to supply System Date;
        Supplier<Date> sup = () -> new Date();

        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println("----------------------------------");

        // Supplier to supply 6-digit Random OTP:
        Supplier<String> otps = () -> {
            String otp = "";
            for(int i = 1; i <= 6; i++)
                otp += (int) (Math.random() * 10);

            return otp;
        };

        System.out.println(otps.get());
        System.out.println(otps.get());
        System.out.println(otps.get());
        System.out.println(otps.get());
        System.out.println("----------------------------------");


        // Supplier to supply Random Passwords
        Supplier<String> supl = () -> {
            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
            Supplier<Integer> d = () -> (int)(Math.random() * 10);
            Supplier<Character> c = () -> symbols.charAt((int)(Math.random() * 29));
            String pwd = "";
            for(int i = 1; i <= 8; i++)
                if(i % 2 == 0)
                    pwd += d.get();
                else
                    pwd += c.get();


            return pwd;
        };

        System.out.println(supl.get());
        System.out.println(supl.get());
        System.out.println(supl.get());
        System.out.println(supl.get());
        System.out.println(supl.get());
        System.out.println(supl.get());
    }
}

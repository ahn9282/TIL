package study.optional;

import java.util.Optional;

public class OptionalCreationMain1 {
    public static void main(String[] args) {
        String nonNullableValue = "Hello Optional!!";
        Optional<String> opt1 = Optional.of(nonNullableValue);


        Optional<String> opt2 = Optional.ofNullable("Hello!");
        Optional<String> opt3 = Optional.ofNullable(null);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt3 = " + opt3);

        Optional<String> opt4 = Optional.empty();
        System.out.println("opt4 = " + opt4);

        String opt2Get = opt2.orElseGet(() -> "non");
        String opt3Get = opt3.orElseGet(() -> "non");
        System.out.println("opt2Get = " + opt2Get);
        System.out.println("opt3Get = " + opt3Get);
    }
}

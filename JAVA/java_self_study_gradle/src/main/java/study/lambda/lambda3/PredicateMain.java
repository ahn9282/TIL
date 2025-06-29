package study.lambda.lambda3;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        Predicate<Integer> predicate = num -> num % 2 == 0;
        boolean result1 = predicate.test(10);
        System.out.println("result1 = " + result1);

        boolean result2 = predicate.test(5);
        System.out.println("result2 = " + result2);

        Function<Integer, Boolean> function = value -> value % 2 == 0;
        Boolean resultFunction = function.apply(4);
        System.out.println("resultFunction = " + resultFunction);
    }
}

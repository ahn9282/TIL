package study.lambda.lambda3;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BiMain {
    public static void main(String[] args) {
        BiConsumer<Integer, String> biConsumer = (a, b) -> System.out.println(b + a);

        biConsumer.accept(1, "개수는 ");

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;
        boolean test = biPredicate.test(5, 2);
        System.out.println("biPredicate = " + test);
    }
}

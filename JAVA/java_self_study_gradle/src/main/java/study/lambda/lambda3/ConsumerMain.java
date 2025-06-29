package study.lambda.lambda3;

import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println("s = " + s);
        consumer.accept("hello consumer");


    }
}

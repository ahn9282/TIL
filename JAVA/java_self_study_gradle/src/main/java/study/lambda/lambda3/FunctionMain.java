package study.lambda.lambda3;

import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        Function<String, Integer> function1 = str -> str.length();

        Integer result1 = function1.apply("asdgwqe");
        System.out.println("result1 = " + result1);


    }
}

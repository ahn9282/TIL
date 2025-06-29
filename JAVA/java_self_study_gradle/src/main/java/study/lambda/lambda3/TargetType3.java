package study.lambda.lambda3;

import java.util.function.Function;

public class TargetType3 {

    public static void main(String[] args) {
        Function<Integer, String> function1 = i -> "value = " + i;
        String result1 = function1.apply(15);
        System.out.println("result1 = " + result1);

        Function<Integer, String> function2 = function1;
        String result2 = function2.apply(14);
        System.out.println("result2 = " + result2);

    }
}

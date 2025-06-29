package study.lambda.lambda3;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {
    public static void main(String[] args) {
        Function<Integer, Integer> function = x -> x * x;
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println("unaryOperator = " + unaryOperator.apply(4));
        System.out.println("unaryOperator = " + unaryOperator.apply(5));


        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a * b;
        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
        System.out.println("biFunction = " + biFunction.apply(4,5));
        System.out.println("binaryOperator = " + binaryOperator.apply(4, 5));
    }
}

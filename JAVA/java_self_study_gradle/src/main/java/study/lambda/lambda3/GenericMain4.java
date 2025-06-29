package study.lambda.lambda3;

public class GenericMain4 {
    public static void main(String[] args) {

        GenericFunction<String, String> toUpperCase = str -> str.toUpperCase();
        GenericFunction<String, Integer> length = str -> str.length();
        GenericFunction<Integer, Integer> square = x -> x * x;
        GenericFunction<Integer, Boolean> isEven = num -> num % 2 == 0;

        System.out.println("toUpperCase = " + toUpperCase.apply("hello"));
        System.out.println("length = " + length.apply("hello"));
        System.out.println("square = " + square.apply(45));
        System.out.println("isEven = " + isEven.apply(45));
    }


    @FunctionalInterface
    interface GenericFunction<T, R>{
        R apply(T t);
    }

}

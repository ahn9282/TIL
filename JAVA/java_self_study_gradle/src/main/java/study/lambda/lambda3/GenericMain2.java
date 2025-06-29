package study.lambda.lambda3;

public class GenericMain2 {
    public static void main(String[] args) {

        ObjectFunction upperCase = s -> ((String)s).toUpperCase();
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        ObjectFunction square = n -> String.valueOf((Integer)n * (Integer)n);
        Integer result2 = Integer.valueOf(square.apply(4));
        System.out.println("result2 = " + result2);
    }


    @FunctionalInterface
    interface ObjectFunction{
        String apply(Object obj);
    }

}

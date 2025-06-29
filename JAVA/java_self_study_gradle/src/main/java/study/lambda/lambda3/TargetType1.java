package study.lambda.lambda3;

public class TargetType1 {
    public static void main(String[] args) {

        FunctionA functionA = i -> "value = " + i;
        String result1 = functionA.apply(10);
        System.out.println("result1 = " + result1);

        FunctionB functionB = o -> "value = " + o;
    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer integer);
    }    @FunctionalInterface
    interface FunctionB {
        String apply(Integer integer);
    }
}

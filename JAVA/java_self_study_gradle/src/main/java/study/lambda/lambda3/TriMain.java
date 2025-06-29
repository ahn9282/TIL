package study.lambda.lambda3;

public class TriMain {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction = (a, b, c) -> a + b + c;
        Integer triApply = triFunction.apply(4, 6, 9);
        System.out.println("triApply = " + triApply);


    }
}

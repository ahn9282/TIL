package study.method_ref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV2 {

    public static void main(String[] args) {
        BinaryOperator<Integer> add1 = (x, y) -> add(x, y);
        BinaryOperator<Integer> add2 = (x, y) -> add(x, y);
        BinaryOperator<Integer> add3 = (x, y) -> add(x, y);

        Integer apply1 = add1.apply(1, 2);
        System.out.println("apply1 = " + apply1);

        Integer apply2 = add2.apply(1, 2);
        System.out.println("apply2 = " + apply2);

        Integer apply3 = add3.apply(1, 2);
        System.out.println("apply3 = " + apply3);
    }

    static int add(int x, int y) {
        return x + y;
    }
}

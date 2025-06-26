package study.lambda.lambda2;

import study.lambda.lambda1.MyFunction;

public class LambdaPassMain3 {

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        MyFunction sub = getOperation("sub");

        System.out.println("add.apply(1,2) = " + add.apply(1,2));
        System.out.println("sub.apply(1,2) = " + sub.apply(1,2));
    }

    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return null;
        }
    }
}

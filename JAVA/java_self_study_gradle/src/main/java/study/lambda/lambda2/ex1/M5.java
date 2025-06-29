package study.lambda.lambda2.ex1;

import study.lambda.lambda1.MyFunction;

public class M5 {
    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        MyFunction sub = getOperation("sub");
        MyFunction etc = getOperation("sad");

        System.out.println("add(1,2) = " + add.apply(1, 2));
        System.out.println("sub(1,2) = " + sub.apply(1, 2));
        System.out.println("etc(1,2) = " + etc.apply(1, 2));

    }

    static MyFunction getOperation(String str){
        switch (str){
            case "add":
                return (a,b) -> a + b;
            case "sub":
                return (a,b) -> a - b;
            default:
                return (a,b) -> 0;

        }
    }
}

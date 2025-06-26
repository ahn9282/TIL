package study.lambda.lambda1;

import study.lambda.Procedure;

public class LambdaSimple3 {

    public static void main(String[] args) {
        MyFunction myFunction1 = (int a, int b) -> a + b;
        System.out.println("myFunction1 = " + myFunction1.apply(1,2));

        MyFunction myFunction2 = (int a, int b) -> a + b;
        System.out.println("myFunction2 = " + myFunction2.apply(1,2));
    }
}

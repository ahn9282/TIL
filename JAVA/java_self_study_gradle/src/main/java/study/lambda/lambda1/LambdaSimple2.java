package study.lambda.lambda1;

import study.lambda.Procedure;

public class LambdaSimple2 {

    public static void main(String[] args) {
        Procedure proc1 = () ->{
                System.out.println("hello! lambda!");
        };
        proc1.run();
        Procedure proc2 = () -> System.out.println("hello! lambda!");
        proc2.run();

    }
}

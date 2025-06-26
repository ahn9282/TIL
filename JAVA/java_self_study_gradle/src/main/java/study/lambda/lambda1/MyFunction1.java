package study.lambda.lambda1;

public class MyFunction1 {

    public static void main(String[] args) {
        MyFunction myFunction = Integer::sum;
        int result = myFunction.apply(1, 2);
        System.out.println("result = " + result);
    }

}

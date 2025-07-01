package study.lambda.mystream;

import java.util.List;

public class MyStreamMainV2 {

    public static void main(String[] args) {

    }

    private static MyStreamV2 methodChain(List<Integer> numbers) {
        return MyStreamV2.of(numbers).filter(n -> n % 2 == 0).map(n -> n * 2);
    }
}

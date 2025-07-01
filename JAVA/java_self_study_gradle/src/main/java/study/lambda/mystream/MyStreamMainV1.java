package study.lambda.mystream;

import java.util.List;

public class MyStreamMainV1 {

    public static void main(String[] args) {

    }

    private static MyStreamV1 methodChain(List<Integer> numbers) {
        MyStreamV1 stream = new MyStreamV1(numbers);
        MyStreamV1 map = stream.filter(n -> n % 2 == 0).map(n -> n * 2);
        return map;
    }
}

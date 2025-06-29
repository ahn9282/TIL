package study.lambda.lambda3;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class PrimitiveMain {
    public static void main(String[] args) {

        IntFunction<String> function = i -> "개수는 " + i + "개입니다.";
        String intFunction = function.apply(4);
        System.out.println("intFunction = " + intFunction);

        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println("toIntFunction = " + toIntFunction.applyAsInt("hello"));

        IntToLongFunction intToLongFunction = x -> x * 100L;
        System.out.println("intToLongFunction = " + intToLongFunction.applyAsLong(12));

    }
}

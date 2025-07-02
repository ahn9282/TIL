package study.method_ref;

import study.lambda.mystream.MyStreamV3;

import java.util.List;
import java.util.function.BiFunction;

public class MethodRefEx6 {

    public static void main(String[] args) {

        Person kim = new Person("Kim");

        BiFunction<Person, Integer, String> fun1 = (p, num) -> p.introduceWithNumber(num);
        System.out.println("person.introduceWithNumber - " + fun1.apply(kim, 2));
    }
}

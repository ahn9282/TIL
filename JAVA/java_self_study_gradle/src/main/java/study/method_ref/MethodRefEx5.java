package study.method_ref;

import study.lambda.mystream.MyStreamV3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx5 {

    public static void main(String[] args) {

        List<Person> list = List.of(new Person("Kim"), new Person("Park"), new Person("An"));

        List<String> result1 = MyStreamV3.of(list).map(Person::introduce).map(String::toUpperCase).toList();
        System.out.println("result1 = " + result1);

    }
}

package study.method_ref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx2 {

    public static void main(String[] args) {
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
        String staticMethod1Apply = staticMethod1.apply("가나=");
        System.out.println("staticMethod1Apply = " + staticMethod1Apply);
        Function<String, String>  staticMethod2 = Person::greetingWithName;
        String staticMethod2Apply = staticMethod2.apply("An");
        System.out.println("staticMethod2Apply = " + staticMethod2Apply);

        Person person = new Person("AN");
        Function<Integer, String> instanceMethod1 = person::introduceWithNumber;
        System.out.println("instanceMethod1:" + instanceMethod1.apply(1));
    }
}

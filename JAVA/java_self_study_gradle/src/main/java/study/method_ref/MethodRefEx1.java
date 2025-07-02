package study.method_ref;

import java.util.function.Supplier;

public class MethodRefEx1 {

    public static void main(String[] args) {
        Supplier<String> staticMethod1 = Person::greeting;
        String result1 = staticMethod1.get();
        System.out.println("result1 = " + result1);

        Person person = new Person("AN");
        Supplier<String> instanceMethod1 = person::introduce;
        System.out.println("instanceMethod1:" + instanceMethod1.get());
    }
}

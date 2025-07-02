package study.method_ref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx3 {

    public static void main(String[] args) {

        Person person1 = new Person("Kim");
        Person person2 = new Person("Park");
        Person person3 = new Person("An");

        Function<Person, String> fun1 = (Person person) -> person.introduce();
        System.out.println("person1.introduce + " + fun1.apply(person1));
        System.out.println("person2.introduce + " + fun1.apply(person2));
        System.out.println("person3.introduce + " + fun1.apply(person3));

        Function<Person, String> fun2 = Person::introduce;
        System.out.println("person1.introduce + " + fun2.apply(person1));
        System.out.println("person2.introduce + " + fun2.apply(person2));
        System.out.println("person3.introduce + " + fun2.apply(person3));


    }
}

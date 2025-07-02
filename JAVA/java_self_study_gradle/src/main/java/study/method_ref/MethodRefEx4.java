package study.method_ref;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {

    public static void main(String[] args) {

        List<Person> list = List.of(new Person("Kim"), new Person("Park"), new Person("An"));

        List<String> names = mapPersonToString(list, Person::getName);
        List<String> introduces = mapPersonToString(list, Person::introduce);
        System.out.println("names = " + names);
        System.out.println("introduces = " + introduces);
        List<String> uppercaseNames = mapStringToString(introduces, String::toUpperCase);
        System.out.println("uppercaseNames = " + uppercaseNames);
    }

    static List<String> mapPersonToString(List<Person> personList, Function<Person, String> fun) {
        List<String> result = new ArrayList();
        for (Person person : personList) {
            String str = fun.apply(person);
            result.add(str);
        }
        return result;
    }
    static List<String> mapStringToString(List<String> list, Function<String, String> fun) {
        List<String> result = new ArrayList();
        for (String s : list) {
            String str = fun.apply(s);
            result.add(str);
        }
        return result;
    }

}

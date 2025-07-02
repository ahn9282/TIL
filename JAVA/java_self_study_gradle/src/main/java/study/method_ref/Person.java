package study.method_ref;

public class Person {
    private String name;

    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        this.name = name;
    }

    public static String greeting(){
        return "Hello";
    }

    public String getName() {
        return name;
    }

    public static String greetingWithName(String name) {
        return "Hello " + name;
    }
    public String introduce(){
        return "I am " + name;
    }

    public String introduceWithNumber(Integer num) {
        return name + num;
    }
}

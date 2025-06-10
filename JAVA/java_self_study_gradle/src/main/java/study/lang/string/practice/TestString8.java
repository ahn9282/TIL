package study.lang.string.practice;

public class TestString8 {

    public static void main(String[] args) {
        String input = "hello@example.com";

        String[] split = input.split("@");
        String id = split[0];
        String domain = split[1];

        System.out.println("id = " + id);
        System.out.println("domain = " + domain);

    }
}

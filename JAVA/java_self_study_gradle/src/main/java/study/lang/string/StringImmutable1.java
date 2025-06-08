package study.lang.string;

public class StringImmutable1 {

    public static void main(String[] args) {

        String str = "hello";
        String combinatedStr = str.concat(" java");
        System.out.println("str = " + str);
        System.out.println("combinatedStr = " + combinatedStr);
    }

}

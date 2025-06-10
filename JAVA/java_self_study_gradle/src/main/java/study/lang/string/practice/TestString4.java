package study.lang.string.practice;

public class TestString4 {

    public static void main(String[] args) {
        String txt = "hello.txt";


        String fileName = txt.substring(0, 5);
        String exName = txt.substring(5, 9);
        System.out.println("fileName = " + fileName);
        System.out.println("exName = " + exName);
    }
}

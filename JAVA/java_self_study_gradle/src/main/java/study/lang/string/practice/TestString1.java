package study.lang.string.practice;

public class TestString1 {

    public static void main(String[] args) {
        String url = "https://www.example.com";

        boolean isStartHttps = url.startsWith("https://");
        System.out.println("isStartHttps? : " + isStartHttps);
    }
}

package study.lambda.start;

public class Ex0Main {

    public static void main(String[] args) {


        String str = "Java";
        ex0Print(str);
        ex0Print("Spring");

    }

    private static void ex0Print(String str) {
        System.out.println("프로그램 시작");
        System.out.println("Hello " + str);
        System.out.println("프로그램 종료");
    }

}

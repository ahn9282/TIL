package study.lambda.ex1;

public class M1After {
    public static void greetMorning() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Morning!");
        System.out.println("=== 끝 ===");
    }
    public static void greetAfternoon() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Afternoon!");
        System.out.println("=== 끝 ===");
    }
    public static void greetEvening() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Evening!");
        System.out.println("=== 끝 ===");
    }
    public static void main(String[] args) {
        StartAndEnd printer = str ->{
            System.out.println("=== 시작 ===");
            System.out.println("Good "+str+"!");
            System.out.println("=== 끝 ===");
        };

        printer.print("Morning");
        printer.print("Afternoon");
        printer.print("Evening");
    }

    static interface StartAndEnd{
        void print(String str);
    }
}
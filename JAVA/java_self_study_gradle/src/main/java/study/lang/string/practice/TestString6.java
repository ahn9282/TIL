package study.lang.string.practice;

public class TestString6 {

    public static void main(String[] args) {
        String str = "               Hello Java      ";

        String trimmed = str.trim();
        System.out.println("trimmed = " + trimmed);
        String stripped = str.strip();
        System.out.println("stripped = " + stripped);
    }
}

package study.lang.string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {
        String str = "Apple, Banana, Orange";

        String[] split = str.split(", ");
        for (String s : split) {
            System.out.println("s = " + s);
        }

        String joinedStr = String.join(" & ", split);
        System.out.println("joinedStr = " + joinedStr);
    }
}

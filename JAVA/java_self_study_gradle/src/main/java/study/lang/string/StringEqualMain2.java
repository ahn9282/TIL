package study.lang.string;

public class StringEqualMain2 {

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println("메서드 호출 비교 1 : " + isSame(str1, str2));

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("메 서드 호출 비교 2 : " + isSame(str3, str4));
    }

    private static boolean isSame(String x, String y) {

        if(x == null || x.length() ==0 || y == null || y.length() ==0) throw new IllegalStateException();

       // return x == y;
        return x.equals(y);
    }
}

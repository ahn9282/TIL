package study.lang.string.method;

public class StringComparisonMain {
    public static void main(String[] args) {
        String str1 = "Hello, Java!";
        String str2 = "Hello, java!";
        String str3 = "Hello World!";

        System.out.println("str1 equals str2 : " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase str2 : "+ str1.equalsIgnoreCase(str2));

        System.out.println(" 'b' compare to 'a' : " + "b".compareTo("a"));
        System.out.println(" 'str1' compare to 'str3' : " + str1.compareTo(str3));
        System.out.println(" 'str1' compare to ignore case 'str2' : " + str1.compareToIgnoreCase(str2));

    }
}

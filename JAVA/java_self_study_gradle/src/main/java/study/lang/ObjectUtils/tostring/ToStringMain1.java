package study.lang.ObjectUtils.tostring;

public class ToStringMain1 {

    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        System.out.println("string = " + string);

        System.out.println("object = " + object);

        System.out.println("object.toString() = " + object.toString());
    }
}

package study.lang.ObjectUtils.solve;

public class SolveMain {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(100, 20);
        Rectangle rectangle2 = new Rectangle(100, 20);

        System.out.println("rectangle1 = " + rectangle1);
        System.out.println("rectangle2 = " + rectangle2);
        System.out.println(rectangle1 == rectangle2);
        System.out.println(rectangle1.equals(rectangle2));
    }
}

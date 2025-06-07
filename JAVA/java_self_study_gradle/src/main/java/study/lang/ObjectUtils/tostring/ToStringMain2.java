package study.lang.ObjectUtils.tostring;

public class ToStringMain2 {

    public static void main(String[] args) {

        Car car = new Car("아방이");
        Dog dog1 = new Dog("개1", 3);
        Dog dog2 = new Dog("개2", 14);
        System.out.println("car = " + car);
        System.out.println("dog1 = " + dog1);
        System.out.println("dog2 = " + dog2);
    }
}

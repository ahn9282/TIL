package study.lang.immutable.address;

public class RefMain_1_2 {
    public static void main(String[] args) {
        Address a = new Address("서울");
        Address b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        change(b,"부산");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static void change(Address address, String changedAddress) {
        System.out.println("해당 주소로 변경합니다. : " + changedAddress);
        address.setValue(changedAddress);
    }
}

package study.lang.lang.immutable.address;

public class RefMain_2 {
    public static void main(String[] args) {
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b = change("부산");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static ImmutableAddress change(String changedAddress) {
        System.out.println("해당 주소로 변경합니다. : " + changedAddress);
        //address.setValue(changedAddress);
        return new ImmutableAddress(changedAddress);
    }
}

package study.lang.lang.immutable.address;

public class MemberMainV1 {
    public static void main(String[] args) {

        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        Address address1 = memberB.getAddress();
        // address1.setValue("부산");
        memberB.setAddress(new Address("부산"));
        System.out.println("memberB 주소 변경 후 ===============================");

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}

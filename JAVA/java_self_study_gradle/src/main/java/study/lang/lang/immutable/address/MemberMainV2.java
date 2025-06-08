package study.lang.lang.immutable.address;

public class MemberMainV2 {
    public static void main(String[] args) {

        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        ImmutableAddress address1 = memberB.getAddress();
        // address1.setValue("부산");
        memberB.setAddress(new ImmutableAddress("부산"));
        System.out.println("memberB 주소 변경 후 ===============================");

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}

package study.lang.lang.immutable.address;

public class MemberV2 {

    private String name;
    private ImmutableAddress address;

    @Override
    public String toString() {
        return "MemberV1{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public ImmutableAddress getAddress() {
        return address;
    }

    public void setAddress(ImmutableAddress address) {
        this.address = address;
    }

    public MemberV2(String name, ImmutableAddress address) {
        this.name = name;
        this.address = address;
    }
}

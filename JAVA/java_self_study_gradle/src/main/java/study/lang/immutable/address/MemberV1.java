package study.lang.immutable.address;

public class MemberV1 {

    private String name;
    private Address address;

    @Override
    public String toString() {
        return "MemberV1{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MemberV1(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

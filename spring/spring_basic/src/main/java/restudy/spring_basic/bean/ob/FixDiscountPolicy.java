package restudy.spring_basic.bean.ob;

public class FixDiscountPolicy implements DiscountPolicy {
    private int fixedDc;

    @Override
    public Integer getDiscountAmount(int amount) {
        return amount - fixedDc;
    }

}

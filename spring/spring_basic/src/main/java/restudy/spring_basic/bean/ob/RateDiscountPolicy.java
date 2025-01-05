package restudy.spring_basic.bean.ob;

public class RateDiscountPolicy implements DiscountPolicy{

    private Double rate;

    @Override
    public Integer getDiscountAmount(int amount) {
        return (int) (amount * (1 - rate));
    }

}

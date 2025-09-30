package specification_pattern.yc;

public class PriceSpec implements Specification2 {
    private int maxPrice;

    public PriceSpec(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean isSatisfiedBy(Product item) {
        return item.getPrice() <= maxPrice;
    }
}

package specification_pattern.yc;

public class InStockSpec implements Specification2 {

    @Override
    public boolean isSatisfiedBy(Product item) {
        return item.getStock() > 0;
    }
}

package specification_pattern.yc;

public class OrSpec implements Specification2 {
    private Specification2 spec1;
    private Specification2 spec2;

    public OrSpec(Specification2 spec1, Specification2 spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    @Override
    public boolean isSatisfiedBy(Product item) {
        return spec1.isSatisfiedBy(item) || spec2.isSatisfiedBy(item);
    }
}

package specification_pattern.yc;

public class NotSpec implements Specification2 {
    private Specification2 spec;

    public NotSpec(Specification2 spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(Product item) {
        return !spec.isSatisfiedBy(item);
    }
}

package specification_pattern.yc;

public class CategorySpec implements Specification2 {
    private String category;

    public CategorySpec(String category) {
        this.category = category;
    }

    @Override
    public boolean isSatisfiedBy(Product item) {
        return item.getCategory().equals(category);
    }

}

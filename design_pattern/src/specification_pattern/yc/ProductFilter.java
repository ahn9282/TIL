package specification_pattern.yc;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    public static List<Product> filter(List<Product> items, Specification2 spec) {
        return items.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    public static void printProducts(List<Product> products) {
        products.forEach(p ->
                System.out.println(p.getName() + " - " + p.getCategory() + " - $" + p.getPrice() + " - Stock" + p.getStock())
        );
    }
}

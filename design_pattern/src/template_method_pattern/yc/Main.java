package template_method_pattern.yc;

public class Main {
    public static void main(String[] args) {

        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("\n Making  tea...");
        tea.prepareRecipe();

        System.out.println("\n Making coffee...");
        coffee.prepareRecipe();

    }
}

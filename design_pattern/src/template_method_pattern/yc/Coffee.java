package template_method_pattern.yc;

public class Coffee extends Beverage{

    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

}

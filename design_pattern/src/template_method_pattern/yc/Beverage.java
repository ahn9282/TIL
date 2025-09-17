package template_method_pattern.yc;

public abstract class Beverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");

    }

    abstract void brew();
    abstract void addCondiments();
}

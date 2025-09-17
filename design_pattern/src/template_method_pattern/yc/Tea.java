package template_method_pattern.yc;

public class Tea extends Beverage {
    void brew(){
        System.out.println("Steeping the tea");
    }

    void addCondiments(){
        System.out.println("Adding Lemon");
    }

}

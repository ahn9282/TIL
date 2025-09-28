package prototype_pattern.yc;

public class Main1 {

    public static void main(String[] args) {
        Person original = new Person("John", 30, "123 Main St");
        original.displayInfo();

        Person cloned = original.clone();
        cloned.setAddress("456 Clone St");

        System.out.println("\n after cloning and modifying the clone");

        original.displayInfo();
        cloned.displayInfo();
    }
}

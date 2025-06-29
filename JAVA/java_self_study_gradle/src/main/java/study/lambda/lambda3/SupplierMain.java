package study.lambda.lambda3;

import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "suppplier";
        String result = supplier.get();
        System.out.println("result = " + result);
    }
}

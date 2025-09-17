package startegy_pattern.yc;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCartPayment("js", "12321312312"));

        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPayment("junsub@asdsa.com"));

        cart.checkout(200);

    }
}

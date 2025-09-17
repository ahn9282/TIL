package factory_pattern.yc;

public class Main2 {
    public static void main(String[] args) {

        FinancialInfo userInfo = new FinancialInfo("1234-2144124-124124", "ajs@design.pattern", "1231452");

        PaymentFactory factory = new CreditCardPaymentFactory();
        Payment payment = factory.createPayment(userInfo);
        payment.processPayment(100.0);

        factory = new BankTransferPaymentFactory();
        payment.processPayment(200.0);
        payment = factory.createPayment(userInfo);

        factory = new PayPalPaymentFactory();
        payment = factory.createPayment(userInfo);
        payment.processPayment(300.0);
    }
}

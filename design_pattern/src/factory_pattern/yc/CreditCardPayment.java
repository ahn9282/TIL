package factory_pattern.yc;


public class CreditCardPayment implements Payment {
    private String creditCardNumber;

    public CreditCardPayment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit card : $" + amount);
    }
}

package startegy_pattern.yc;

public class CreditCartPayment implements PaymentStrategy{

    private String name;
    private String cardNumber;

    public CreditCartPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println( "Paying " + amount + " using Credit Card " + cardNumber);
    }
}

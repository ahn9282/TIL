package factory_pattern.yc;

public class CreditCardPaymentFactory extends PaymentFactory{
    @Override
    Payment createPayment(FinancialInfo info) {
        return new CreditCardPayment(info.getCreditNumber());
    }
}

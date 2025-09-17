package factory_pattern.yc;

public class PayPalPaymentFactory extends PaymentFactory{
    @Override
    Payment createPayment(FinancialInfo info) {
        return new PayPalPayment(info.getPaypalEmail());
    }

}

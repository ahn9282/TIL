package factory_pattern.yc;

public class BankTransferPaymentFactory extends PaymentFactory {
    @Override
    Payment createPayment(FinancialInfo info) {
        return new BankTransferPayment(info.getBankAccountNumber());
    }
}

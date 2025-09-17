package factory_pattern.yc;

abstract class PaymentFactory {
    abstract Payment createPayment(FinancialInfo financialInfo);

}

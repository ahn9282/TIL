package factory_pattern.yc;

public class BankTransferPayment implements Payment {
    private String bankAccountNumber;

    public BankTransferPayment(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Bank transfer : $" + amount);
    }
}

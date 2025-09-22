package proxy_pattern.yc;

public class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(int amount) {

        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Current balance : " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + " deposited. Current balance : " + balance);
    }
}

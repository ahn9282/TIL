package proxy_pattern.yc;

public class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String userRole;

    public BankAccountProxy(String userRole, int amount) {
        this.userRole = userRole;
        this.realBankAccount = new RealBankAccount(amount);
    }

    private boolean hasAccess() {
        return "Admin".equals(userRole);
    }

    @Override
    public void withdraw(int amount) {
        if (hasAccess()) {
            realBankAccount.withdraw(amount);
        } else {
            System.out.println("Access denied. Only Admin can withdraw.");
        }
    }

    @Override
    public void deposit(int amount) {
        realBankAccount.deposit(amount);
    }
}

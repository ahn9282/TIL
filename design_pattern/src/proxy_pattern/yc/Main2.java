package proxy_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        BankAccount adminAccount = new BankAccountProxy("Admin", 1000);
        adminAccount.deposit(500);
        adminAccount.withdraw(200);

        BankAccountProxy userAccount = new BankAccountProxy("User", 1000);
        userAccount.deposit(500);
        userAccount.withdraw(300);

    }
}

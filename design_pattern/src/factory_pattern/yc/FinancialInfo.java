package factory_pattern.yc;

public class FinancialInfo {
    private String creditNumber;
    private String paypalEmail;
    private String bankAccountNumber;

    public String getCreditNumber() {
        return creditNumber;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public FinancialInfo(String creditNumber, String paypalEmail, String bankAccountNumber) {
        this.creditNumber = creditNumber;
        this.paypalEmail = paypalEmail;
        this.bankAccountNumber = bankAccountNumber;
    }
}

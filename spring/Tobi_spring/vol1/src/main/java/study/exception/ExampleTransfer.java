package study.exception;

import java.math.BigDecimal;

public class ExampleTransfer {

    public static void main(String[] args) {
        try {
            Account account = new Account(new BigDecimal("100.00"));
            BigDecimal amount = new BigDecimal("30.00");

            BigDecimal balance = account.withdraw(amount);
            System.out.println("남은 잔액: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("출금 실패: " + e.getMessage());
        }
    }

    private static class Account {
        private BigDecimal balance;

        public Account(BigDecimal balance) {
            this.balance = balance;
        }

        public BigDecimal withdraw(BigDecimal amount) {
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
            }
            if (amount.compareTo(balance) > 0) {
                throw new IllegalArgumentException("잔액이 부족합니다.");
            }

            balance = balance.subtract(amount);
            return balance;
        }
    }
}

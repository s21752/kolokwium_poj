package bank.account;

import bank.account.validation.AccountNumber;

import java.math.BigDecimal;

public class Account {

    public final static int BANK_IDENTIFICATOR_START_INDEX = 3;
    public final static int BANK_IDENTIFICATOR_END_INDEX = 3 + 4;

    @AccountNumber
    private final String accountNumber;
    private BigDecimal cashAmount;

    private final int userId;

    public Account(BigDecimal cashAmount, String accountNumber, int userId) {
        this.cashAmount = cashAmount;
        this.accountNumber = accountNumber;
        this.userId = userId;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account)
            return ((Account) obj).accountNumber.replaceAll("\\s", "")
                    .equals(
                            this.accountNumber.replaceAll("\\s", "")
                    );
        else
            return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

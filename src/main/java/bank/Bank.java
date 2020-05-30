package bank;

import bank.account.Account;
import bank.user.User;

import java.util.List;
import java.util.Set;

public class Bank {

    private String bankName;
    private final String bankIdentificator;

    // can be Set in stead of List, but it was said that we have to use List
    private List<Account> usersAccounts;
    private Set<User> users;

    public Bank(String bankName, String bankIdentificator) {
        this.bankName = bankName;
        this.bankIdentificator = bankIdentificator;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIdentificator() {
        return bankIdentificator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bank)
            return ((Bank) obj).bankIdentificator.equals(this.bankIdentificator);
        else
            return super.equals(obj);
    }
}

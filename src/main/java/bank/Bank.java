package bank;

import bank.account.Account;
import bank.user.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Bank {

    private final static String NO_USER_FOUND_ERROR_MESSAGE = "No user with this id found";

    private String bankName;
    private final String bankIdentificator;

    // can be Set in stead of List, but it was said that we have to use List
    private List<Account> usersAccounts;
    private Set<User> users;

    public Bank(String bankName, String bankIdentificator) {
        this.bankName = bankName;
        this.bankIdentificator = bankIdentificator;
    }

    public FullBankUser getFullUser(int userId) {
        Optional<User> currentUser = users.stream().filter(user -> user.getUserId() == userId).findFirst();

        if (currentUser.isPresent())
            return new FullBankUser(
                    currentUser.get(),
                    usersAccounts.stream().filter(account ->
                            account.getUserId() == currentUser.get().getUserId()).collect(Collectors.toList())
            );
        else
            throw new RuntimeException(NO_USER_FOUND_ERROR_MESSAGE);
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

    public static class FullBankUser {

        private User user;

        public FullBankUser(User user, List<Account> accounts) {
            this.user = user;
            this.accounts = accounts;
        }

        private List<Account> accounts;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Account> getAccounts() {
            return accounts;
        }

        public void setAccounts(List<Account> accounts) {
            this.accounts = accounts;
        }
    }
}

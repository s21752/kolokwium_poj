package bank.utils;

import bank.Bank;
import bank.account.Account;
import bank.user.User;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankHelper {

    private Bank currentBank;

    private static BankHelper instance;

    private BankHelper() {};

    public static BankHelper getInstance(Bank bank) {
        if (instance == null)
            instance = new BankHelper();

        instance.currentBank = bank;
        return instance;
    }

    public BigDecimal accountsBalance(User user) {
        List<Account> accounts = currentBank.getFullUser(user.getUserId()).getAccounts();

        List<BigDecimal> cashAmountsOnEveryAccount = accounts.stream().map(Account::getCashAmount).collect(Collectors.toList());

        BigDecimal sum = new BigDecimal(0);
        cashAmountsOnEveryAccount.forEach(sum::add);

        return sum;
    }

    public Optional<List<Account>> getAccountsForUser(User user) {

        try {
            Bank.FullBankUser bankUser = currentBank.getFullUser(user.getUserId());
            return Optional.of(bankUser.getAccounts());
        } catch (Bank.NoUserException e) {
            System.out.println("No user found in this bank");
            return Optional.empty();
        }
    }
}

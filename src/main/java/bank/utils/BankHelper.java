package bank.utils;

import bank.Bank;

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
}

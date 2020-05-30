package utils.validation;

import bank.account.Account;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

public class ValidationHelper {

    private final static String DEFAULT_NUMBER_TO_CHECK = "12345";

    private static ValidationHelper instance;
    private final Validator validator;

    private ValidationHelper() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static ValidationHelper getInstance() {
        if (instance == null) {
            instance = new ValidationHelper();
        }

        return instance;
    }

    public boolean isAccountNumberValid(String number) {

        if (number == null)
            number = DEFAULT_NUMBER_TO_CHECK;

        Account account = new Account(new BigDecimal(50), number, 2);
        return validate(account);
    }

    private <T> boolean validate(T validation) {
        Set<ConstraintViolation<T>> validate = validator.validate(validation);
        System.out.println(validate);

        return validate.isEmpty();
    }
}

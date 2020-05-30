package bank.account.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements ConstraintValidator<AccountNumber, String> {

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext constraintValidatorContext) {
        return accountNumber
                .replaceAll("\\s", "")
                .matches("[0-9]{26}");
    }

    @Override
    public void initialize(AccountNumber constraintAnnotation) {
    }
}

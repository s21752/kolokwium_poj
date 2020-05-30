import utils.validation.ValidationHelper;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Kolokwium!!!");

        validateAccountNumber();
    }

    private static void validateAccountNumber() {
        System.out.println(ValidationHelper.getInstance().isAccountNumberValid("11111111111111111111111190"));
    }
}

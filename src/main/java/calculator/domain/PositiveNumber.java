package calculator.domain;

import static calculator.constants.ErrorMessage.EMPTY_ERROR;
import static calculator.constants.ErrorMessage.ONLY_NATURAL_NUMBER_ERROR;
import static calculator.constants.ErrorMessage.OVERFLOW_ERROR;
import static calculator.constants.ErrorMessage.ZERO_START_NUMBER_ERROR;
import static calculator.constants.RegexPattern.NUMBER_VALIDATE;

import java.math.BigInteger;

public class PositiveNumber {
    private static final String ZERO = "0";
    private static final int NUMBER_LENGTH = 1;
    private final int value;

    public PositiveNumber(String number) {
        numberEmpty(number);
        zeroStartValidation(number);
        numberFormatValidation(number);
        overflowValidation(number);
        this.value = Integer.parseInt(number);
    }

    public int sum(int currentSum) {
        CheckSumOverflow(currentSum, value);
        return currentSum + value;
    }

    private void numberEmpty(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR.getMessage());
        }
    }

    private void zeroStartValidation(String number) {
        if (number.length() > NUMBER_LENGTH && number.startsWith(ZERO)) {
            throw new IllegalArgumentException(number + ZERO_START_NUMBER_ERROR.getMessage());
        }
    }

    private void numberFormatValidation(String number) {
        if (!number.matches(NUMBER_VALIDATE.getRegex())) {
            throw new IllegalArgumentException(ONLY_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private void overflowValidation(String number) {
        BigInteger bigInteger = new BigInteger(number);
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);

        if (bigInteger.compareTo(maxInt) > 0) {
            throw new IllegalArgumentException(OVERFLOW_ERROR.getMessage());
        }
    }

    private void CheckSumOverflow(int total, int number) {
        if (total > Integer.MAX_VALUE - number) {
            throw new IllegalArgumentException(OVERFLOW_ERROR.getMessage());
        }
    }
}

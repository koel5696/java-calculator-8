package calculator.domain;

import static calculator.constants.ErrorMessage.INPUT_FORMAT_ERROR;
import static calculator.constants.ErrorMessage.NEGATIVE_NUMBER_ERROR;
import static calculator.constants.ErrorMessage.ZERO_START_NUMBER_ERROR;

public class NumberValidation {
    private static final char ZERO = '0';
    private static final int START_INDEX = 0;
    private static final int NUMBER_LENGTH = 2;

    public static int[] parseIntService(String[] numbers) {
        int[] finalNumber = new int[numbers.length];
        for (int i = START_INDEX; i < numbers.length; i++) {
            zeroStartValidation(numbers[i]);
            finalNumber[i] = numberFormatValidation(numbers[i]);
            negativeValidation(finalNumber[i]);
        }
        return finalNumber;
    }

    public static void zeroStartValidation(String number) {
        if (number.length() > NUMBER_LENGTH && number.charAt(START_INDEX) == ZERO) {
            throw new IllegalArgumentException(ZERO_START_NUMBER_ERROR.getMessage());
        }
    }

    public static int numberFormatValidation(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getMessage());
        }
    }

    public static void negativeValidation(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }
}

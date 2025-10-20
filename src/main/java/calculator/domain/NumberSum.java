package calculator.domain;

import static calculator.constants.ErrorMessage.SUM_OVERFLOW;

public class NumberSum {
    private static final int INITIAL_TOTAL = 0;

    public static int sum(int[] finalNumbers) {
        int total = INITIAL_TOTAL;
        for (int number : finalNumbers) {
            CheckOverflow(total, number);
            total += number;
        }
        return total;
    }

    private static void CheckOverflow(int total, int number) {
        if (number > 0 && total > Integer.MAX_VALUE - number) {
            throw new IllegalArgumentException(SUM_OVERFLOW.getMessage());
        }
    }
}

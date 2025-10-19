package calculator.domain;

import java.util.Arrays;

public class NumberSum {
    public static int sum(int[] finalNumbers) {
        return Arrays.stream(finalNumbers).sum();
    }
}

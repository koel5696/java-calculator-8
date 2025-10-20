package calculator.domain;

import static calculator.constants.ErrorMessage.EMPTY_ERROR;
import static calculator.constants.RegexPattern.CUSTOM_SETTING_PREFIX;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private static final int INITIAL_TOTAL = 0;
    private static final int CUSTOM_SETTING_LENGTH = 5;
    private final String inputWord;

    public CalculatorService(String inputWord) {
        this.inputWord = inputWord;
        CheckedEmpty();
    }

    private void CheckedEmpty() {
        if (inputWord == null || inputWord.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR.getMessage());
        }
    }

    public SplitService selectCustomOrDefault() {
        if (inputWord.startsWith(CUSTOM_SETTING_PREFIX.getRegex())
                && inputWord.length() >= CUSTOM_SETTING_LENGTH) {
            return new CustomWordSplit();
        }

        return new DefaultWordSplit();
    }

    public int numberValidService(String[] numbers) {
        List<PositiveNumber> finalNumbers = new ArrayList<>();
        for (String number : numbers) {
            finalNumbers.add(new PositiveNumber(number));
        }
        return sumService(finalNumbers);
    }

    private int sumService(List<PositiveNumber> finalNumbers) {
        int total = INITIAL_TOTAL;
        for (PositiveNumber currentNumber : finalNumbers) {
            total = currentNumber.sum(total);
        }
        return total;
    }
}

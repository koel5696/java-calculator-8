package calculator.domain;

import static calculator.constants.RegexPattern.CUSTOM_REGEX_PATTEN;
import static calculator.constants.RegexPattern.DEFAULT_REGEX_PATTEN;
import static calculator.domain.NumberSum.sum;
import static calculator.domain.numberValidation.parseIntService;

public class CustomWordSplit {
    private static final int CUSTOM_SETTING_START = 0;
    private static final int CUSTOM_SETTING_LENGTH = 5;
    private static final int CUSTOM_SETTING_AFTER_WORD = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final char REGEX_OR = '|';

    public static int customSplitService(String inputWord) {
        char customDelimiter = customFormatValidation(inputWord);
        String word = inputWord.substring(CUSTOM_SETTING_AFTER_WORD);
        String[] numbers = combineDelimiter(word, customDelimiter);
        return sum(parseIntService(numbers));
    }

    public static char customFormatValidation(String inputWord) {
        String customization = inputWord.substring(CUSTOM_SETTING_START, CUSTOM_SETTING_LENGTH);
        if (!customization.matches(CUSTOM_REGEX_PATTEN.getRegexPattern())) {
            throw new IllegalArgumentException();
        }
        return customization.charAt(CUSTOM_DELIMITER_INDEX);
    }

    public static String[] combineDelimiter(String word, char customDelimiter) {
        String combineDelimiterRegex = DEFAULT_REGEX_PATTEN.getRegexPattern() + REGEX_OR + customDelimiter;
        return word.split(combineDelimiterRegex);
    }
}

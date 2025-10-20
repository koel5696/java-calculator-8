package calculator.domain;

import static calculator.constants.ErrorMessage.CUSTOM_SETTING_ERROR;
import static calculator.constants.RegexPattern.CUSTOM_REGEX_PATTEN;
import static calculator.constants.RegexPattern.DEFAULT_REGEX_PATTEN;
import static calculator.constants.RegexPattern.REGEX_OR;
import static calculator.domain.NumberSum.sum;
import static calculator.domain.NumberValidation.parseIntService;

import java.util.regex.Pattern;

public class CustomWordSplit {
    private static final int CUSTOM_SETTING_START = 0;
    private static final int CUSTOM_SETTING_LENGTH = 5;
    private static final int STRING_TO_CALCULATE = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    public static int customSplitService(String inputWord) {
        char customDelimiter = customFormatValidation(inputWord);
        String word = inputWord.substring(STRING_TO_CALCULATE);
        String[] numbers = combineDelimiter(word, customDelimiter);
        return sum(parseIntService(numbers));
    }

    public static char customFormatValidation(String inputWord) {
        String customization = inputWord.substring(CUSTOM_SETTING_START, CUSTOM_SETTING_LENGTH);
        if (!customization.matches(CUSTOM_REGEX_PATTEN.getRegexPattern())) {
            throw new IllegalArgumentException(CUSTOM_SETTING_ERROR.getMessage());
        }
        return customization.charAt(CUSTOM_DELIMITER_INDEX);
    }

    public static String[] combineDelimiter(String word, char customDelimiter) {
        String quotedCustomDelimiter = Pattern.quote(String.valueOf(customDelimiter));
        String combineDelimiterRegex =
                DEFAULT_REGEX_PATTEN.getRegexPattern() + REGEX_OR.getRegexPattern() + quotedCustomDelimiter;
        return word.split(combineDelimiterRegex);
    }
}

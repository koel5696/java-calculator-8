package calculator.domain;

import static calculator.constants.ErrorMessage.CUSTOM_SETTING_ERROR;
import static calculator.constants.RegexPattern.CUSTOM_REGEX_PATTEN;
import static calculator.constants.RegexPattern.DEFAULT_REGEX_PATTEN;
import static calculator.constants.RegexPattern.REGEX_OR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomWordSplit implements SplitService {
    private static final int STRING_TO_CALCULATE = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    @Override
    public String[] split(String inputWord) {
        char customDelimiter = customFormatValidation(inputWord);
        String word = inputWord.substring(STRING_TO_CALCULATE);
        return combineDelimiter(word, customDelimiter);
    }

    private char customFormatValidation(String inputWord) {
        Matcher matcher = CUSTOM_REGEX_PATTEN.getRegexPattern().matcher(inputWord);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(CUSTOM_SETTING_ERROR.getMessage());
        }
        return inputWord.charAt(CUSTOM_DELIMITER_INDEX);
    }

    private String[] combineDelimiter(String word, char customDelimiter) {
        String quotedCustomDelimiter = Pattern.quote(String.valueOf(customDelimiter));
        String combineDelimiterRegex =
                DEFAULT_REGEX_PATTEN.getRegex() + REGEX_OR.getRegex() + quotedCustomDelimiter;
        return word.split(combineDelimiterRegex);
    }
}

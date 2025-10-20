package calculator.domain;

import static calculator.constants.RegexPattern.DEFAULT_REGEX_PATTEN;
import static calculator.domain.NumberSum.sum;
import static calculator.domain.NumberValidation.parseIntService;

public class DefaultWordSplit {

    public static int defaultSplit(String inputWord) {
        String[] words = inputWord.split(DEFAULT_REGEX_PATTEN.getRegexPattern());
        return sum(parseIntService(words));
    }


}

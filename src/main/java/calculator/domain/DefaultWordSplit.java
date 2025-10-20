package calculator.domain;

import static calculator.constants.RegexPattern.DEFAULT_REGEX_PATTEN;


public class DefaultWordSplit implements SplitService {

    @Override
    public String[] split(String inputWord) {
        return inputWord.split(DEFAULT_REGEX_PATTEN.getRegex());
    }
}

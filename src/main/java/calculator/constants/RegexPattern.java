package calculator.constants;

import java.util.regex.Pattern;

public enum RegexPattern {
    CUSTOM_SETTING_PREFIX("//"),
    CUSTOM_REGEX_PATTEN("//\\D\\\\n"),
    NUMBER_VALIDATE("\\d+"),
    REGEX_OR("|"),
    DEFAULT_REGEX_PATTEN(",|:");

    private final String regex;
    private final Pattern pattern;

    RegexPattern(String regexPattern) {
        this.regex = regexPattern;
        this.pattern = Pattern.compile(regexPattern);
    }

    public String getRegex() {
        return regex;
    }

    public Pattern getRegexPattern() {
        return pattern;
    }
}

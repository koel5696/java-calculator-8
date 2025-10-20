package calculator.constants;

public enum RegexPattern {
    CUSTOM_REGEX_PATTEN("//\\D\\\\n"),
    REGEX_OR("|"),
    DEFAULT_REGEX_PATTEN(",|:");

    private final String regexPattern;

    RegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public String getRegexPattern() {
        return regexPattern;
    }
}

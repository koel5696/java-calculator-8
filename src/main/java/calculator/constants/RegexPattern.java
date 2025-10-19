package calculator.constants;

public enum RegexPattern {
    CUSTOM_REGEX_PATTEN("//\\D\\\\n"),
    DEFAULT_REGEX_PATTEN(",|:");

    private String regexPattern;

    RegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public String getRegexPattern() {
        return regexPattern;
    }
}

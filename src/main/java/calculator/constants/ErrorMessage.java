package calculator.constants;

public enum ErrorMessage {
    EMPTY_ERROR("빈 값은 허용되지 않습니다."),
    CUSTOM_SETTING_ERROR("커스텀 구분자는 숫자가 아닌 문자(공백 포함) 1개를 문자열 처음 \"//\"와 \"\\n\" 사이에 지정해야 합니다."),
    ZERO_START_NUMBER_ERROR("와 같은 숫자 형식은 올바르지 않습니다."),
    OVERFLOW_ERROR("숫자의 허용 범위를 초과했습니다."),
    NEGATIVE_NUMBER_ERROR("음수는 허용되지 않습니다."),
    ONLY_NATURAL_NUMBER_ERROR("0 혹은 양의 정수만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package calculator.constants;

public enum ErrorMessage {
    CUSTOM_SETTING_ERROR("커스텀 구분자는 숫자가 아닌 문자(공백 포함) 1개를 문자열 처음 \"//\"와 \"\\n\" 사이에 지정해야 합니다."),
    ZERO_START_NUMBER_ERROR("0으로 시작하는 숫자 형식은 올바르지 않습니다."),
    INPUT_FORMAT_ERROR("문자, 소수이거나 허용치를 초과한 숫자입니다."),
    NEGATIVE_NUMBER_ERROR("음수는 허용되지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

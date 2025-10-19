package calculator.constants;

public enum ErrorMessage {
    ZERO_START_NUMBER_ERROR("0으로 시작하는 숫자 형식은 올바르지 않습니다."),
    INPUT_FORMAT_ERROR("공백 혹은 문자의 형식이거나 계산이 지원되지 않는 실수입니다."),
    NEGATIVE_NUMBER_ERROR("음수는 허용되지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package calculator.constants;

public enum ErrorMessage {
    CUSTOM_SETTING_ERROR("커스텀 구분자 지정 형식 오류 혹은 2개 이상의 커스텀 구분자를 작성했습니다."),
    ZERO_START_NUMBER_ERROR("0으로 시작하는 숫자 형식은 올바르지 않습니다."),
    INPUT_FORMAT_ERROR("올바르지 않은 형식이거나 실수의 입력 혹은 오버플로우 입니다."),
    NEGATIVE_NUMBER_ERROR("음수는 허용되지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

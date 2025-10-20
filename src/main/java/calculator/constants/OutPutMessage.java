package calculator.constants;

public enum OutPutMessage {
    INPUT_STRING("덧셈할 문자열을 입력해주세요."),
    SUM_RESULT("결과 : ");

    private final String message;

    OutPutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package subway.exception;

public enum ErrorMessage {

    NOT_BLANK_INPUT("입력은 공백일 수 없습니다. 다시 입력해주세요."),
    INVALID_INPUT("잘못된 입력입니다. 다시 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}



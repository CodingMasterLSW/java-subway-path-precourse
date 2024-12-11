package subway.view;

public class OutputView {

    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String COURSE_CHECK_MESSAGE = "1. 경로 조회";
    private static final String QUIT_MESSAGE = "Q. 종료";
    private static final String BLANK = "";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void startMessage() {
        printMessage(MAIN_MESSAGE);
        printMessage(COURSE_CHECK_MESSAGE);
        printMessage(QUIT_MESSAGE);
        printMessage(BLANK);
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}

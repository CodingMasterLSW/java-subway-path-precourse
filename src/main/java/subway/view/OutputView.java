package subway.view;

public class OutputView {

    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String COURSE_CHECK_MESSAGE = "1. 경로 조회";
    private static final String QUIT_MESSAGE = "Q. 종료";
    private static final String BLANK = "";
    private static final String COURSE_STANDARD_MESSAGE = "##경로 기준";
    private static final String SHORTEST_DISTANCE = "1. 최단 거리";
    private static final String SHORTEST_TIME = "2. 최소 시간";
    private static final String ROLL_BACK = "B. 돌아가기";

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

    public void courseMessage() {
        printMessage(COURSE_STANDARD_MESSAGE);
        printMessage(SHORTEST_DISTANCE);
        printMessage(SHORTEST_TIME);
        printMessage(ROLL_BACK);
        printMessage(BLANK);
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}

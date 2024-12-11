package subway.view;

import java.util.List;
import subway.domain.CalculateResultDto;

public class OutputView {

    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String COURSE_CHECK_MESSAGE = "1. 경로 조회";
    private static final String QUIT_MESSAGE = "Q. 종료";
    private static final String BLANK = "";
    private static final String COURSE_STANDARD_MESSAGE = "##경로 기준";
    private static final String SHORTEST_DISTANCE = "1. 최단 거리";
    private static final String SHORTEST_TIME = "2. 최소 시간";
    private static final String ROLL_BACK = "B. 돌아가기";
    private static final String CHECK_RESULT_MESSAGE = "## 조회 결과";
    private static final String INFO_FORMAT = "[INFO] ---";
    private static final String TOTAL_DISTANCE = "[INFO] 총 거리: %skm";
    private static final String TOTAL_TIME = "[INFO] 총 소요 시간: %s분";
    private static final String VISIT_STATION = "[INFO] %s";

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

    public void printResult(CalculateResultDto calculateResultDto) {
        printMessage(INFO_FORMAT);
        System.out.printf(TOTAL_DISTANCE, calculateResultDto.getDistance());
        printMessage(BLANK);
        System.out.printf(TOTAL_TIME, calculateResultDto.getTime());
        printMessage(BLANK);
        printMessage(INFO_FORMAT);
        List<String> stations = calculateResultDto.getStations();
        for (String station : stations) {
            System.out.printf(VISIT_STATION, station);
            printMessage(BLANK);
        }
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}

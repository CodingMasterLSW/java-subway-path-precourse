package subway.view;

import static subway.exception.ErrorMessage.INVALID_INPUT;
import static subway.exception.ErrorMessage.NOT_BLANK_INPUT;

import java.util.Scanner;

public class InputView {

    private static final String BLANK = "";
    private static final String CHOOSE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String END_STATION_MESSAGE = "## 도착역을 입력하세요.";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView create(Scanner scanner) {
        return new InputView(scanner);
    }

    public String userInput() {
        String userInput = scanner.nextLine();
        validateInput(userInput);
        return userInput;
    }

    public String chooseFunction() {
        printMessage(CHOOSE_MESSAGE);
        String userInput = userInput();
        validateChooseInput(userInput);
        return userInput;
    }

    public String chooseSpecificFunction() {
        printMessage(CHOOSE_MESSAGE);
        String userInput = userInput();
        validateChooseInputContainRollBack(userInput);
        return userInput;
    }

    public String inputStartStation() {
        printMessage(START_STATION_MESSAGE);
        return userInput();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void validateInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(NOT_BLANK_INPUT.getMessage());
        }
    }

    private void validateChooseInput(String userInput) {
        if (userInput.equals("1") || userInput.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    private void validateChooseInputContainRollBack(String userInput) {
        if (userInput.equals("1") || userInput.equals("2") || userInput.equals("B")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

}

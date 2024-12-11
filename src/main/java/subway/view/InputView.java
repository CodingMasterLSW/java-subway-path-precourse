package subway.view;

import static subway.exception.ErrorMessage.NOT_BLANK_INPUT;

import java.util.Scanner;

public class InputView {

    private static final String BLANK = "";
    private static final String CHOOSE_MESSAGE = "## 원하는 기능을 선택하세요.";
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
        printMessage(BLANK);
        printMessage(CHOOSE_MESSAGE);
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

}

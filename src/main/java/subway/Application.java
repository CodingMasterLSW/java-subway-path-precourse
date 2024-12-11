package subway;

import java.util.Scanner;
import subway.config.AppConfig;
import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController subwayController = AppConfig.createController(scanner);
        subwayController.start();
    }
}

package subway.config;

import java.util.Scanner;
import subway.controller.SubwayController;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static SubwayController createController(Scanner scanner) {
        return new SubwayController(InputView.create(scanner), OutputView.create(), createService());
    }

    public static SubwayService createService() {
        return new SubwayService();
    }

}

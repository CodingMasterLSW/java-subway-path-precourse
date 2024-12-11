package subway.config;

import subway.controller.SubwayController;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static SubwayController createController() {
        return new SubwayController(InputView.create(), OutputView.create(), createService());
    }

    public static SubwayService createService() {
        return new SubwayService();
    }

}

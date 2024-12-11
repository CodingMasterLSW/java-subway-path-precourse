package subway.controller;

import static subway.exception.ErrorMessage.NOT_EXIST_STATION;

import java.util.function.Supplier;
import subway.domain.StationRepository;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;
    private final SubwayService subwayService;

    public SubwayController(InputView inputView, OutputView outputView,
            SubwayService subwayService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.subwayService = subwayService;
    }

    public void init() {
        subwayService.setup();
    }

    public void start() {
        outputView.startMessage();
        String userInput = retryOnInvalidInput(() -> inputView.chooseFunction());
        outputView.courseMessage();
        String specificUserInput = retryOnInvalidInput(() -> inputView.chooseSpecificFunction());

        String startStation = handleStartStation();

    }

    private String handleStartStation() {
        return retryOnInvalidInput(() -> {

            String startStation = inputView.inputStartStation();
            validateStation(startStation);
            return startStation;
        });
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void validateStation(String station) {
        if (StationRepository.hasStation(station)) {
            return;
        }
        throw new IllegalArgumentException(NOT_EXIST_STATION.getMessage());
    }

}

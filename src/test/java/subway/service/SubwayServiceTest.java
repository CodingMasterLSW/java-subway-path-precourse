package subway.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayServiceTest {

    private SubwayService subwayService = new SubwayService();

    @BeforeEach
    void init() {
        subwayService.setup();
    }

    @DisplayName("지하철 저장 검증 테스트")
    @Test
    void subway_validation_test() {
        List<Station> stations = StationRepository.stations();

        List<String> compareStation = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> validateStationNames = new ArrayList<>();

        for (Station station : stations) {
            validateStationNames.add(station.getName());
        }

        assertThat(compareStation.containsAll(validateStationNames));
    }

}

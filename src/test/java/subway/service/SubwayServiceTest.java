package subway.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.CalculateResultDto;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayServiceTest {

    private SubwayService subwayService = new SubwayService();

    @BeforeEach
    void init() {
        subwayService.init();
    }

    @DisplayName("지하철 저장 검증 테스트")
    @Test
    void subway_validation_test() {
        List<Station> stations = StationRepository.stations();
        List<java.lang.String> compareString = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<java.lang.String> validateStringNames = new ArrayList<>();
        for (Station station :stations) {
            validateStringNames.add(station.getName());
        }
        assertThat(compareString.containsAll(validateStringNames));
    }

    @DisplayName("노선 저장 검증 테스트")
    @Test
    void line_validation_test() {
        List<Line> lines = LineRepository.lines();
        List<java.lang.String> compareLine = List.of("2호선", "3호선", "신분당");
        List<java.lang.String> validateLineNames = new ArrayList<>();
        for (Line line : lines) {
            validateLineNames.add(line.getName());
        }
        assertThat(compareLine.containsAll(validateLineNames));
    }

    @DisplayName("교대역 - 양재역 최소시간 값은 9km, 7분 이어야 한다.")
    @Test
    void 교대_양재_실행_최소시간_테스트() {
        CalculateResultDto calculateResultDto = subwayService.calculateDistance(true, "교대역", "양재역");
        List<String> expectedResult = List.of("교대역", "남부터미널역", "양재역");
        int distance = calculateResultDto.getDistance();
        int time = calculateResultDto.getTime();
        List<String> stations = calculateResultDto.getStations();
        for (String station : stations) {
            System.out.println(station);
        }
        assertThat(stations).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(distance).isEqualTo(9);
        assertThat(time).isEqualTo(7);
    }

    @DisplayName("교대역 - 양재역 최소거리 값은 4km, 11분 이어야 한다.")
    @Test
    void 교대_양재_실행_최소거리_테스트() {
        CalculateResultDto calculateResultDto = subwayService.calculateDistance(false, "교대역", "양재역");
        List<String> expectedResult = List.of("교대역", "강남역", "양재역");
        List<String> stations = calculateResultDto.getStations();
        int distance = calculateResultDto.getDistance();
        int time = calculateResultDto.getTime();
        assertThat(stations).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(distance).isEqualTo(4);
        assertThat(time).isEqualTo(11);
    }
}

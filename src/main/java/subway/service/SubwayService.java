package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayService {

    public void setup() {
        setupStation();
        setupLine();
    }

    private void setupStation() {
        List<String> stationNames = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName : stationNames) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private void setupLine() {
        List<String> lineNames = List.of("2호선", "3호선", "신분당선");
        for (String lineName : lineNames) {
            Line line = new Line(lineName);
            LineRepository.addLine(line);
        }
    }

}

package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationInfo;
import subway.domain.StationRepository;

public class SubwayService {

    private static final List<String> stationNames = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

    public void init() {
        initStation();
        initLineAndSectionAnd();
    }

    private void initStation() {
        for (String stationName : stationNames) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private void initLineAndSectionAnd() {
        StationInfo[] stationInfos = StationInfo.values();
        for (StationInfo stationInfo : stationInfos) {
            initLine(stationInfo);
            initSection(stationInfo);
        }
    }
    private void initLine(StationInfo stationInfo) {
        String lineName = stationInfo.getLineName();
        Line line = new Line(lineName);
        LineRepository.addLine(line);
    }

    private void initSection(StationInfo stationInfo) {
        List<Section> sections = stationInfo.getSections();
        for (Section section : sections) {
            SectionRepository.addSection(section);
        }
    }
}

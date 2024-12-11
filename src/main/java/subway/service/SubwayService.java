package subway.service;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.CalculateResultDto;
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

    public CalculateResultDto calculateDistance(boolean isTime, String startStation, String endStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        List<Section> sections = SectionRepository.getSections();
        graphAddStation(graph);
        DijkstraShortestPath dijkstraShortestPath = decideDijkstraShortestPath(isTime, graph, sections);
        GraphPath path = dijkstraShortestPath.getPath(startStation, endStation);
        return createCalculateResultDto(path);
    }

    private DijkstraShortestPath decideDijkstraShortestPath(boolean isTime,
            WeightedMultigraph<String, DefaultWeightedEdge> graph, List<Section> sections) {
        DijkstraShortestPath dijkstraShortestPath;
        if (isTime) {
            dijkstraShortestPath = addGraphByTime(graph, sections);
            return dijkstraShortestPath;
        }
        dijkstraShortestPath = addGraphByDistance(graph, sections);
        return dijkstraShortestPath;
    }

    private CalculateResultDto createCalculateResultDto(GraphPath path) {
        List<String> shortestPath = path.getVertexList();
        int weight = (int) path.getWeight();
        int time = calculateTime(shortestPath);
        return CalculateResultDto.toDto(weight, time, shortestPath);
    }

    private void graphAddStation(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            graph.addVertex(station.getName());
        }
    }

    private DijkstraShortestPath addGraphByTime(WeightedMultigraph<String, DefaultWeightedEdge> graph, List<Section> sections) {
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getStartStation(), section.getEndStation()), section.getCost().getTime());
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath;
    }

    private DijkstraShortestPath addGraphByDistance(WeightedMultigraph<String, DefaultWeightedEdge> graph, List<Section> sections) {
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getStartStation(), section.getEndStation()), section.getCost().getDistance());
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath;
    }

    private int calculateTime(List<String> shortestPath) {
        int time = 0;
        for (int i=0; i<shortestPath.size()-1; i++) {
            Section section = SectionRepository.findSectionByStationName(
                    shortestPath.get(i), shortestPath.get(i + 1));
            time += section.getCost().getTime();
        }
        return time;
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

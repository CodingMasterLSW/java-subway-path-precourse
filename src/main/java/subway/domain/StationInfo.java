package subway.domain;

import java.util.List;

public enum StationInfo {
    LINE_TWO("2호선",
            List.of(
                    new Section("교대역", "강남역", new Cost(2, 3)),
                    new Section("강남역", "교대역", new Cost(2, 3)),
                    new Section("강남역", "역삼역", new Cost(2, 3)),
                    new Section("역삼역", "강남역", new Cost(2, 3))
            )
    ),
    LINE_THREE("3호선",
            List.of(
                    new Section("교대역", "남부터미널역", new Cost(3, 2)),
                    new Section("남부터미널역", "교대역", new Cost(3, 2)),
                    new Section("남부터미널역", "양재역", new Cost(6, 5)),
                    new Section("양재역", "남부터미널역", new Cost(6, 5)),
                    new Section("양재역", "매봉역", new Cost(1, 1)),
                    new Section("매봉역", "양재역", new Cost(1, 1))
            )
    ),
    LINE_NEW("신분당선",
            List.of(
                    new Section("강남역", "양재역", new Cost(2, 8)),
                    new Section("양재역", "강남역", new Cost(2, 8)),
                    new Section("양재역", "양재시민의숲역", new Cost(10, 3)),
                    new Section("양재시민의숲역", "양재역", new Cost(10, 3))
            )
    );

    private final String lineName;
    private final List<Section> sections;

    StationInfo(String lineName, List<Section> sections) {
        this.lineName = lineName;
        this.sections = sections;
    }

    public String getLineName() {
        return lineName;
    }

    public List<Section> getSections() {
        return sections;
    }
}

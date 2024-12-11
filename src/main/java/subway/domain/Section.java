package subway.domain;

public class Section {

    private final String startStation;
    private final String endStation;
    private final Cost cost;

    public Section(String startStation, String endStation, Cost cost) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.cost = cost;
    }

    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public Cost getCost() {
        return cost;
    }
}

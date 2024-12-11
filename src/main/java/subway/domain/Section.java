package subway.domain;

public class Section {

    private final String startString;
    private final String endString;
    private final Cost cost;

    public Section(String startString, String endString, Cost cost) {
        this.startString = startString;
        this.endString = endString;
        this.cost = cost;
    }

    public String getStartString() {
        return startString;
    }

    public String getEndString() {
        return endString;
    }

    public Cost getCost() {
        return cost;
    }
}

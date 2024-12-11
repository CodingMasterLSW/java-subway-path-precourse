package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final java.lang.String name;
    private List<String> strings;

    public Line(java.lang.String name) {
        this.name = name;
        this.strings = new ArrayList<>();
    }

    public java.lang.String getName() {
        return name;
    }

    public void addStation(String string) {
        strings.add(string);
    }

}

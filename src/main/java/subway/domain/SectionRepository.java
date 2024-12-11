package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public static Section findSectionByStationName(String startStationName, String endStationName) {
        return sections.stream()
                .filter(section -> section.getStartStation().equals(startStationName)
                        && section.getEndStation().equals(endStationName))
                .findFirst()
                .orElse(null);
    }

}

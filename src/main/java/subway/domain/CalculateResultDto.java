package subway.domain;

import java.util.List;

public class CalculateResultDto {

    private final int distance;
    private final int time;
    private final List<String> stations;

    private CalculateResultDto(int distance, int time, List<String> stations) {
        this.distance = distance;
        this.time = time;
        this.stations = stations;
    }

    public static CalculateResultDto toDto(int distance, int time, List<String> stations) {
        return new CalculateResultDto(distance, time, stations);
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public List<String> getStations() {
        return stations;
    }
}

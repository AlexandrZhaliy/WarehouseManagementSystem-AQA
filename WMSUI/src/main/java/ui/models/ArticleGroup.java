package ui.models;

public enum ArticleGroup {
    VEHICLE_REGISTRATION_NUMBERS("Vehicle registration numbers"),
    GPS_TRACKERS("GPS trackers"),
    CENTRAL_GOVERNMENT("Central Government"),
    ORDINARY("Ordinary"),
    TRACKER_DEVICES("Tracker devices");

    private String name;

    ArticleGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package ui.models;

public enum VehicleType {
    VEHICLE("Vehicle");

    private String name;

    VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

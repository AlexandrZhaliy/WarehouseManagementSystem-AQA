package ui.models;

public enum PlateShape {
    SQUARE("Square");

    private String name;

    PlateShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package ui.models;

public enum WarehousesType {
    CENTRAL_WAREHOUSE("Central warehouse"),
    INSTALLATION_WAREHOUSE("Installation warehouse");

    private String name;

    WarehousesType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

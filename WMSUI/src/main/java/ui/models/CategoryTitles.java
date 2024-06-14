package ui.models;

public enum CategoryTitles {
    ALLOCATE_ORDERS("Allocate Orders"),
    ARTICLES("Articles"),
    DASHBOARD("Dashboard"),
    INSTALATION_KITS("Instalation kits"),
    INSTALATION_ORDERS("Instalation Orders"),
    ORDERS("Orders"),
    REG_NUMBERS("Reg.numbers"),
    REPORTS("Reports"),
    SUPPLIERS("Suppliers"),
    SYSTEM_MANAGEMENT("System management"),
    TRACKER_DEVICE("Tracker device"),
    WAREHOUSES("Warehouses"),
    VEHICLE_OWNERS("Vehicle owners"),
    VEHICLES("Vehicles"),
    COMPANY("Company");

    private String name;

    CategoryTitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

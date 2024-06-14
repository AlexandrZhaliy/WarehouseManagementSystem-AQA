package ui.models;

public enum GroupType {
    USERS("Users"),
    COMPANIES("Companies"),
    SUPPLIERS("Suppliers"),
    WAREHOUSES("Warehouses"),
    ARTICLES("Articles"),
    MANUFACTURERS("Manufacturers");

    private String name;

    GroupType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package ui.models;

public enum Orders {
    PURCHASE_ORDER("Purchase order"),
    DEPRECIATE_ORDER("Depreciate order"),
    TRANSFER_ORDER("Transfer order");

    private String name;

    Orders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

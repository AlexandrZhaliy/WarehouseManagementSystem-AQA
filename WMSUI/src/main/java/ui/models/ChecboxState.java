package ui.models;

public enum ChecboxState {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String name;

    ChecboxState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


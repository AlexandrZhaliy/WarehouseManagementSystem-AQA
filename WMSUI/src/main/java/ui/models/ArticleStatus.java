package ui.models;

public enum ArticleStatus {
    NEW("New"),
    SHIPPING("Shipping"),
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DONE("Done");

    private String name;

    ArticleStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

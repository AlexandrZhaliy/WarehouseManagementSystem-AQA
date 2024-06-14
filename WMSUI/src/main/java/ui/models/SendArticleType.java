package ui.models;

public enum SendArticleType {
    SEND_ARTICLES("Send articles"),
    SEND_SPECIFIC_UNIQUE_ARTICLES("Send specific Unique articles");

    private String name;

    SendArticleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

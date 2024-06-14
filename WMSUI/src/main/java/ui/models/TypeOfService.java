package ui.models;

public enum TypeOfService {
    FIRST_TIME_REGISTRATION("First Time Registration"),
    POST_REGISTRATION("Post Registration");

    private String name;

    TypeOfService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
